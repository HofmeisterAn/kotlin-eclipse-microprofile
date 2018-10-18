package com.andrehofmeister.schoolhouse.feature.student

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@ApplicationScoped
@Path("/api/students")
internal open class StudentController {
  @field:[Inject DefaultStudentService]
  private lateinit var studentService: StudentService

  @GET
  open fun all(): List<Student> {
    return studentService.all()
  }
}
