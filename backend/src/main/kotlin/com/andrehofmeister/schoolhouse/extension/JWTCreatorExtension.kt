package com.andrehofmeister.schoolhouse.extension

import com.auth0.jwt.JWTCreator
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

internal fun JWTCreator.Builder.withPayload(payloadClaims: Map<String, Any>): JWTCreator.Builder {
  // Todo: Any better approach to add payload claims to the JWTCreator?
  payloadClaims.forEach { k, v ->
    when (v) {
      is Int -> withClaim(k, v)
      is Long -> withClaim(k, v)
      is Double -> withClaim(k, v)
      is Boolean -> withClaim(k, v)
      is String -> withClaim(k, v)
      is Date -> withClaim(k, v)
      is LocalDateTime -> withClaim(k, Date.from(v.atZone(ZoneId.systemDefault()).toInstant()))
      is Array<*> -> {
        if (v.isNotEmpty()) {
          when (v.first()) {
            is Int -> {
              withArrayClaim(k, v.filterIsInstance<Int>().toTypedArray())
            }
            is Long -> {
              withArrayClaim(k, v.filterIsInstance<Long>().toTypedArray())
            }
            is String -> {
              withArrayClaim(k, v.filterIsInstance<String>().toTypedArray())
            }
          }
        }
      }
    }
  }

  return this
}
