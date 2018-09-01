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
    TODO("not implemented")
  }

  override fun create(obj: Student) {
    TODO("not implemented")
  }

  override fun update(obj: Student) {
    TODO("not implemented")
  }

  override fun delete(obj: Student) {
    TODO("not implemented")
  }
}
