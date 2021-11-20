package com.example.nomorerounding

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:1998/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val server: API = retrofit.create(API::class.java)
}