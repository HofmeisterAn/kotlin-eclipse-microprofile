package com.andrehofmeister.schoolhouse.student

import org.eclipse.microprofile.jwt.JsonWebToken
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@ApplicationScoped
@Path("/api/students")
open class StudentController {
  @field:[Inject]
  private lateinit var callerPrincipal: JsonWebToken

  @field:[Inject DefaultStudentService]
  private lateinit var studentService: StudentService

  @GET
  open fun all(): List<Student> {
    return studentService.all()
  }
}
