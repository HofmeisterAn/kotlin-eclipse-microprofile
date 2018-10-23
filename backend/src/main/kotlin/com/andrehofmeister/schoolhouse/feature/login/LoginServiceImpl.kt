package com.andrehofmeister.schoolhouse.feature.login

import com.andrehofmeister.schoolhouse.feature.student.Student
import com.andrehofmeister.schoolhouse.security.JsonWebToken
import java.time.LocalDateTime

@DefaultLoginService
internal class LoginServiceImpl : LoginService {
  companion object {
    @JvmStatic
    private val jwt: JsonWebToken by lazy {
      JsonWebToken()
    }
  }

  override fun authorize(credentials: Credentials): String {
    val id = Student.default.id.toString()

    val today = LocalDateTime.now()

    val payloadClaims = hashMapOf(
      "iss" to "org.eclipse.microprofile14",
      "sub" to id,
      "aud" to "http://localhost:8080",
      "exp" to today.plusWeeks(1),
      "nbf" to today,
      "iat" to today,
      "jti" to id,
      "groups" to arrayOf("USER")
    )

    return jwt.sign(payloadClaims)
  }
}
