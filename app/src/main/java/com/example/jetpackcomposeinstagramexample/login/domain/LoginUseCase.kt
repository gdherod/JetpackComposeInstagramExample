package com.example.jetpackcomposeinstagramexample.login.domain

import com.example.jetpackcomposeinstagramexample.login.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()

    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}