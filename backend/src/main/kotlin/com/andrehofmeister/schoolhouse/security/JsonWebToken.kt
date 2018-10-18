package com.andrehofmeister.schoolhouse.security

import java.security.PrivateKey
import java.security.PublicKey

internal class JsonWebToken {
  private val publicKey: PublicKey by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    val rsaPublicPem = JsonWebToken::class.java.getResource("/rsa-public.pem").file
    PemUtils.readPublicKeyFromFile(rsaPublicPem, "RSA")
  }

  private val privateKey: PrivateKey by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    val rsaPrivatePem = JsonWebToken::class.java.getResource("/rsa-private.pem").file
    PemUtils.readPrivateKeyFromFile(rsaPrivatePem, "RSA")
  }
}
