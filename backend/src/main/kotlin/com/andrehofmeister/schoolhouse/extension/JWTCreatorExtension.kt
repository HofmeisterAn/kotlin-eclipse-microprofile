package com.andrehofmeister.schoolhouse.extension

import com.auth0.jwt.JWTCreator
import java.util.Date

fun JWTCreator.Builder.withPayload(payloadClaims: HashMap<String, Any>): JWTCreator.Builder {
  payloadClaims.forEach { k, v ->
    when (v) {
      is Int -> withClaim(k, v)
      is Long -> withClaim(k, v)
      is Double -> withClaim(k, v)
      is Boolean -> withClaim(k, v)
      is String -> withClaim(k, v)
      is Date -> withClaim(k, v)
    }
  }

  return this
}
