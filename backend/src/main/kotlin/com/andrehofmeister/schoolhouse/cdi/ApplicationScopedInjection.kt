package com.andrehofmeister.schoolhouse.cdi

import javax.enterprise.context.ApplicationScoped
import javax.inject.Qualifier

@ApplicationScoped
@MustBeDocumented
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class ApplicationScopedInjection
