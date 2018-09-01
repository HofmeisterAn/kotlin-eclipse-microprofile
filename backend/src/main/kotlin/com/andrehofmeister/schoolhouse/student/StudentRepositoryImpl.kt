package com.andrehofmeister.schoolhouse.student

import java.util.UUID

@DefaultStudentRepository
internal class StudentRepositoryImpl : StudentRepository() {
  override fun all(): List<Student> {
    return entityManager.createQuery("select s from Student s", Student::class.java).resultList.toList()
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
