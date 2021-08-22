package com.example.jetpack.data.network

import com.example.jetpack.data.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("login")
    suspend fun login(): Response<User>

}