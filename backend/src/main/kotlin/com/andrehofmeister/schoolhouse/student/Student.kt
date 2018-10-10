package com.andrehofmeister.schoolhouse.student

import java.util.Date
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Student(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  val id: UUID = UUID(0, 0),

  @Column(name = "first_name")
  var firstName: String = "",

  @Column(name = "last_name")
  var lastName: String = "",

  @Column(name = "birthday")
  var birthday: Date = Date()
) {

  companion object {
    val default: Student by lazy {
      Student()
    }
  }

  val fullName: String
    get() = "$firstName $lastName"
}
