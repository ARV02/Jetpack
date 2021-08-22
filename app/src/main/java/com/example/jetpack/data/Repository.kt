package com.example.jetpack.data

import com.example.jetpack.data.network.ApiInterface
import javax.inject.Inject

class Repository @Inject constructor (private val api:ApiInterface){

    suspend fun getUser() = api.login()
}