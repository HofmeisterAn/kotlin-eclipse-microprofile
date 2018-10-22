package com.andrehofmeister.schoolhouse.core

import org.eclipse.microprofile.auth.LoginConfig
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@ApplicationScoped // This scope annotation is necessary, see https://github.com/eclipse/microprofile-jwt-auth/issues/80.
@ApplicationPath("rest")
@LoginConfig(authMethod = "MP-JWT")
internal open class MyApplication : Application()
