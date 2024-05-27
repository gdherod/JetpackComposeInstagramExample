package com.example.jetpackcomposeinstagramexample.login.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient) {
    private val dispatcherIO = Dispatchers.IO

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(dispatcherIO) {
            val response = loginClient.doLogin()
            response.body()?.success ?: false
        }
    }
}