package com.andrehofmeister.schoolhouse.student

import java.util.UUID
import javax.transaction.Transactional

@DefaultStudentRepository
internal open class StudentRepositoryImpl : StudentRepository() {
  override fun all(): List<Student> {
    return entityManager.createQuery("select s from Student s", Student::class.java).resultList.toList()
  }

  override fun get(id: UUID): Student {
    return entityManager.find(Student::class.java, id) ?: Student.default
  }

  @Transactional
  override fun create(obj: Student) {
    entityManager.persist(obj)
  }

  @Transactional
  override fun update(obj: Student) {
    entityManager.merge(obj)
  }

  @Transactional
  override fun delete(obj: Student) {
    entityManager.remove(if (entityManager.contains(obj)) obj else entityManager.merge(obj))
  }
}
