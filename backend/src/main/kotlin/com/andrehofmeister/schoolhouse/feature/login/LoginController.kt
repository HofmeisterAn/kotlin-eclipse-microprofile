package com.andrehofmeister.schoolhouse.feature.login

import com.andrehofmeister.schoolhouse.security.JsonWebToken
import com.auth0.jwt.impl.PublicClaims
import org.json.JSONObject
import java.time.LocalDateTime
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@ApplicationScoped
@Path("/api/login")
internal open class LoginController {
  companion object {
    private val issuer: String
      get() = "org.eclipse.microprofile14"

    @JvmStatic
    private val jwt: JsonWebToken by lazy {
      JsonWebToken()
    }
  }

  private val payloadClaims: Map<String, Any>
    get() {
      val today = LocalDateTime.now()
      return hashMapOf(
        PublicClaims.ISSUER to issuer,
        PublicClaims.SUBJECT to "Subject",
        PublicClaims.AUDIENCE to "Audience",
        PublicClaims.EXPIRES_AT to today.plusWeeks(1),
        PublicClaims.NOT_BEFORE to today,
        PublicClaims.ISSUED_AT to today,
        PublicClaims.JWT_ID to "JWT ID",
        "groups" to arrayOf("USER")
      )
    }

  @POST
  open fun login(): Response {
    val token = jwt.sign(payloadClaims)
    return Response.ok(JSONObject(hashMapOf("token" to token)).toString(), MediaType.APPLICATION_JSON).build()
  }
}
