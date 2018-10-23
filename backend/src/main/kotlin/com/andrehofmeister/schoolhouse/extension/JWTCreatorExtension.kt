package com.andrehofmeister.schoolhouse.extension

import com.auth0.jwt.JWTCreator
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Suppress("UNCHECKED_CAST")
internal fun JWTCreator.Builder.withPayload(payloadClaims: Map<String, Any>): JWTCreator.Builder {
  // Todo: Any better approach to add payload claims to the JWTCreator from a Map?
  this.javaClass.getDeclaredField("payloadClaims").let {
    it.isAccessible = true
    val value = it.get(this) as MutableMap<String, Any>
    payloadClaims.forEach { k, v ->
      if (v is LocalDateTime) {
        value[k] = Date.from(v.atZone(ZoneId.systemDefault()).toInstant()) // Adds compatibility for LocalDateTime
      } else {
        value[k] = v
      }
    }
  }

  return this
}
