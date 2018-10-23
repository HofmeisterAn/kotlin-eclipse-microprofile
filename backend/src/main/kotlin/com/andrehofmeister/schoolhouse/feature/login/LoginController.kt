package com.andrehofmeister.schoolhouse.feature.login

import org.json.JSONObject
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@ApplicationScoped
@Path("/api/login")
internal open class LoginController {
  @field:[Inject DefaultLoginService]
  private lateinit var loginService: LoginService

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  open fun login(credentials: Credentials): Response {
    val token = loginService.authorize(credentials)
    return Response.ok(JSONObject(
      hashMapOf(
        "token" to token
      )
    ).toString(), MediaType.APPLICATION_JSON).build()
  }
}
