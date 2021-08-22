package com.example.jetpack.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("userName")
    val userName: String,
    @SerializedName("password")
    val password: String
)
