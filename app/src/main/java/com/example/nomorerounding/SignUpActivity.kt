package com.example.nomorerounding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.lang.reflect.Modifier
import com.example.nomorerounding.model.SignUpDTO
import com.example.nomorerounding.model.SignUpRequestDTO

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc4)

        val Btn_signup = findViewById<Button>(R.id.btn_signup) as Button

        Btn_signup.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "가입되었습니다!", Toast.LENGTH_SHORT).show()
            postTest()
        })
    }

    fun postTest() {
        val BASE_URL = "http://10.0.2.2:1998/"
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val server: API = retrofit.create(API::class.java)

        val KHD = SignUpRequestDTO(
            "19980813",
            "12가1234",
            true,
            false,
            true,
            "qchdkim@naver.com",
            "MALE",
            "qchdkim",
            "김홍덕",
            "12345",
            false
        )

        val callPostSignup = server.postSignUp(KHD)

        callPostSignup.enqueue(object : Callback<SignUpDTO> {
            override fun onResponse(call: Call<SignUpDTO>, response: Response<SignUpDTO>) {
                Log.d("lol", "성공 : ${response.raw()}")
                Log.d("lol", "성공 : ${response.code()}")
                Log.d("lol", "성공 : ${response.message()}")
                Log.d("lol", "성공 : ${response.body()}")

                val rcv: SignUpDTO? = response.body()
                if (rcv != null) {
                    Log.d("lol", "성공 : ${rcv.tokenResponse?.accessToken}")
                }
            }
            override fun onFailure(call: Call<SignUpDTO>, t: Throwable) {
                Log.d("lol", "실패 : $t")
            }
        })
    }


    interface API {
        //@FormUrlEncoded
        @Headers("Content-Type: application/json")
        @POST("/api/user/signup")
        fun postSignUp(@Body JsonObject: SignUpRequestDTO): Call<SignUpDTO>
    }
}