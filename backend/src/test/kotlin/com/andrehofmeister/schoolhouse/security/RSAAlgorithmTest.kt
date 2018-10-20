package com.andrehofmeister.schoolhouse.security

import com.auth0.jwt.impl.PublicClaims
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class RSAAlgorithmTest {
  private val jwt: JsonWebToken by lazy {
    JsonWebToken()
  }

  private val payloadClaims: HashMap<String, Any> by lazy {
    val today = LocalDateTime.now()
    hashMapOf(
      PublicClaims.ISSUER to "Issuer",
      PublicClaims.SUBJECT to "Subject",
      PublicClaims.AUDIENCE to "Audience",
      PublicClaims.EXPIRES_AT to today.plusWeeks(1),
      PublicClaims.NOT_BEFORE to today,
      PublicClaims.ISSUED_AT to today,
      PublicClaims.JWT_ID to "JWT ID"
    )
  }

  @Test
  fun `sign payload claims and verify`() {
    // Given is a jwt payload
    // When the payload has been signed
    val token = jwt.sign(payloadClaims)
    // Then a valid token was created
    jwt.verify(token)
  }
}
