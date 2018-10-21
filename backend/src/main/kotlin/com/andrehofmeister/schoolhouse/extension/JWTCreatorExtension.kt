package com.andrehofmeister.schoolhouse.extension

import com.auth0.jwt.JWTCreator
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

fun JWTCreator.Builder.withPayload(payloadClaims: Map<String, Any>): JWTCreator.Builder {
  payloadClaims.forEach { k, v ->
    when (v) {
      is Int -> withClaim(k, v)
      is Long -> withClaim(k, v)
      is Double -> withClaim(k, v)
      is Boolean -> withClaim(k, v)
      is String -> withClaim(k, v)
      is Date -> withClaim(k, v)
      is LocalDateTime -> withClaim(k, Date.from(v.atZone(ZoneId.systemDefault()).toInstant()))
    }
  }

  return this
}
