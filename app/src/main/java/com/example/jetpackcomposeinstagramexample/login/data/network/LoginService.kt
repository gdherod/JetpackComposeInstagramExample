package com.example.jetpackcomposeinstagramexample.login.data.network

import com.example.jetpackcomposeinstagramexample.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginService {
    private val retrofit = RetrofitHelper.getRetrofit()
    private val dispatcherIO = Dispatchers.IO

    suspend fun doLogin(user: String, password: String): Boolean {
        return withContext(dispatcherIO) {
            val response = retrofit.create(LoginClient::class.java).doLogin(user, password)
            response.body()?.success ?: false
        }
    }
}