package com.andrehofmeister.schoolhouse.core

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
abstract class DefaultRepository<T> : DefaultService<T> {
  @field:[PersistenceContext(unitName = "persistence-unit")]
  protected lateinit var entityManager: EntityManager
}
