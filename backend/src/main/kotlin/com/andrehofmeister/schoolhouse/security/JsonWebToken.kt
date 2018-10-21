package com.andrehofmeister.schoolhouse.security

import com.andrehofmeister.schoolhouse.extension.withPayload
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.impl.PublicClaims
import java.security.PrivateKey
import java.security.PublicKey
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

internal class JsonWebToken {
  companion object {
    @JvmStatic
    private val headerClaims: HashMap<String, Any> by lazy {
      // List of public claims https://www.iana.org/assignments/jwt/jwt.xhtml
      hashMapOf<String, Any>(
        PublicClaims.ALGORITHM to "RSA256",
        PublicClaims.TYPE to "JWT"
      )
    }

    @JvmStatic
    private val publicKey: PublicKey by lazy {
      val rsaPublicPem = JsonWebToken::class.java.getResource("/rsa-public.pem").file
      PemUtils.readPublicKeyFromFile(rsaPublicPem, "RSA")
    }

    @JvmStatic
    private val privateKey: PrivateKey by lazy {
      val rsaPrivatePem = JsonWebToken::class.java.getResource("/rsa-private.pem").file
      PemUtils.readPrivateKeyFromFile(rsaPrivatePem, "RSA")
    }

    @JvmStatic
    private val algorithm: Algorithm by lazy {
      Algorithm.RSA256(publicKey as RSAPublicKey, privateKey as RSAPrivateKey)
    }
  }

  fun sign(payloadClaims: Map<String, Any>): String {
    return JWT.create()
      .withHeader(headerClaims)
      .withPayload(payloadClaims)
      .sign(algorithm)
  }

  fun verify(token: String) {
    JWT.require(algorithm).build().verify(token)
  }
}
