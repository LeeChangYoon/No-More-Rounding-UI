package com.example.nomorerounding

import com.example.nomorerounding.model.SignUpDTO
import com.example.nomorerounding.model.SignUpRequestDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface API {
    //@FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/api/user/signup")
    fun postSignUp(@Body JsonObject: SignUpRequestDTO): Call<SignUpDTO>
}