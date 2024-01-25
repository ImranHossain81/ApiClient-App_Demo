package com.example.apiclientapp_demo

import retrofit2.Call
import retrofit2.http.GET

interface ApiUser {
    @GET("users")
    fun getUsers(): Call<List<UserD>>
}