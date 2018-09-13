package com.andrehofmeister.schoolhouse.student

import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.gradle.archive.importer.embedded.EmbeddedGradleImporter
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(Arquillian::class)
internal class StudentTest {
  companion object {
    @JvmStatic
    @Deployment
    fun createDeployment(): WebArchive {
      return ShrinkWrap.create(EmbeddedGradleImporter::class.java).forThisProjectDirectory().importBuildOutput("./build/libs/app.war").`as`(WebArchive::class.java)
    }
  }

  @field:[Inject DefaultStudentRepository]
  private lateinit var studentRepository: StudentRepository

  @Test
  fun simple_test_without_any_purpose_except_testing_dependency_injection() {
    // We cannot use the Kotlin feature for readable tests here, Arquillian won't run our tests properly.
    assertTrue(studentRepository.all().isEmpty())
  }
}
