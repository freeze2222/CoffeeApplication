package com.coffee.data.utils

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("/test")
    fun getTest(): Call<Any>
}