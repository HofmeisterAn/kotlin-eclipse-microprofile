package com.andrehofmeister.schoolhouse.student

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.gradle.archive.importer.embedded.EmbeddedGradleImporter
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date
import java.util.UUID
import javax.inject.Inject

@RunWith(Arquillian::class)
internal class StudentTest {
  companion object {
    @JvmStatic
    @Deployment
    fun createDeployment(): WebArchive {
      return ShrinkWrap.create(EmbeddedGradleImporter::class.java).forThisProjectDirectory().forTasks("war").withArguments("--exclude-task", "spotlessApply").importBuildOutput("./build/libs/app.war").`as`(WebArchive::class.java)
    }
  }

  @field:[Inject DefaultStudentRepository]
  private lateinit var studentRepository: StudentRepository

  private lateinit var student: Student

  @Before
  fun before() {
    student = Student(UUID(0, 0), "Foo", "Bar", Date())
  }

  @Test
  fun simple_test_without_any_purpose_except_testing_dependency_injection() {
    assertTrue(studentRepository.all().isEmpty())
  }

  @Test
  fun student_repository_create_record() {
    // Given is a new student with default id
    // When a new student record is created
    studentRepository.create(student)
    // Then a unique id gets generated for the student
    assertNotEquals(Student.default.id, student.id)
  }

  @Test
  fun student_repository_update_record() {
    // Given is a new student with default name
    studentRepository.create(student)
    // When his or her name changes
    student.firstName = "Bar"
    student.lastName = "Foo"
    studentRepository.update(student)
    // Then his or her new name is stored in the database
    assertEquals("Bar", studentRepository.get(student.id).firstName)
  }

  @Test
  fun student_repository_delete_record() {
    // Given is a student
    studentRepository.create(student)
    // When he or she leaves the college
    studentRepository.delete(student)
    // Then his or her database record gets deleted
    assertEquals(Student.default, studentRepository.get(student.id))
  }
}
