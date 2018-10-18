package com.andrehofmeister.schoolhouse.core

import javax.ejb.Stateless
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Stateless
internal abstract class DefaultRepository<T> : DefaultService<T> {
  @field:[PersistenceContext(unitName = "persistence-unit")]
  protected open lateinit var entityManager: EntityManager
}
