package com.example.wednesday_kotlin_we

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/users/{ID}")
    fun  getUSer(@Path ("ID") id:Int):Call<ResponseDTO>
}