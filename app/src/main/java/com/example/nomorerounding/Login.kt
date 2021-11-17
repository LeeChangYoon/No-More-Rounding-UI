package com.example.nomorerounding

import retrofit2.Call
import retrofit2.http.*

interface login {
    @POST("api/user/login/")
    fun requestLogin(@Body loginRequest: loginRequest) : Call<loginRequest>
}