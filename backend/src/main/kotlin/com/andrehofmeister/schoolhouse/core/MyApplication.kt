package com.andrehofmeister.schoolhouse.core

import org.eclipse.microprofile.auth.LoginConfig
import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

@LoginConfig(authMethod = "MP-JWT", realmName = "TCK-MP-JWT")
@ApplicationPath("/rest")
internal class MyApplication : Application()
