package com.andrehofmeister.schoolhouse.feature.login

internal interface LoginService {
  fun authorize(credentials: Credentials): String
}
