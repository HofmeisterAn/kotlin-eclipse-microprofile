package com.andrehofmeister.schoolhouse.feature.student

import java.security.Principal
import java.util.UUID
import javax.annotation.security.RolesAllowed
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.QueryParam

@ApplicationScoped
@Path("/api/students")
internal open class StudentController {
  @field:[Inject]
  private lateinit var principal: Principal

  @field:[Inject DefaultStudentService]
  private lateinit var studentService: StudentService

  @GET
  open fun all(): List<Student> {
    return studentService.all()
  }

  @GET
  @Path("/{id}")
  @RolesAllowed("administrator")
  open fun get(@PathParam("id") id: UUID): Student {
    return Student.default
  }

  @GET
  @Path("/query")
  @RolesAllowed("user")
  open fun query(@QueryParam("start") start: Int, @QueryParam("size") size: Int): Student {
    return Student.default
  }
}
