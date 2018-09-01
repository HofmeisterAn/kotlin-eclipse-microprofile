package com.andrehofmeister.schoolhouse.core

import java.util.UUID

interface DefaultService<T> {
  fun all(): List<T>

  fun get(id: UUID): T

  fun create(obj: T)

  fun update(obj: T)

  fun delete(obj: T)
}
