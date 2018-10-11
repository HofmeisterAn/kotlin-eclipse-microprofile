package com.andrehofmeister.schoolhouse.student

import java.util.UUID
import javax.inject.Inject

@DefaultStudentService
internal class StudentServiceImpl : StudentService {
  @field:[Inject DefaultStudentRepository]
  private lateinit var studentRepository: StudentRepository

  override fun all(): List<Student> {
    return studentRepository.all()
  }

  override fun get(id: UUID): Student {
    return studentRepository.get(id)
  }

  override fun create(obj: Student) {
    studentRepository.create(obj)
  }

  override fun update(obj: Student) {
    studentRepository.update(obj)
  }

  override fun delete(obj: Student) {
    studentRepository.delete(obj)
  }
}
