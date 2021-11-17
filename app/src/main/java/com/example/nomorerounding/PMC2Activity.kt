package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import android.security.identity.AccessControlProfileId
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.databinding.Pmc2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

class PMC2Activity : AppCompatActivity() {
    private var _binding: Pmc2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:1998")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val login: login = retrofit.create(login::class.java)

        _binding = Pmc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val ID: EditText = findViewById(R.id.textInputEditText_id)
        val PASSWORD: EditText = findViewById(R.id.textInputEditText_password)

        val intentPMC3 = Intent(this, PMC3Activity::class.java)
        val intentPMC5 = Intent(this, PMC5Activity::class.java)

        binding.buttonSignin.setOnClickListener {
            val loginId = ID.text.toString()
            val password = PASSWORD.text.toString()

            login.requestLogin(loginRequest(loginId, password)).enqueue(object : Callback<loginRequest> {
                override fun onResponse(
                    call: Call<loginRequest>,
                    response: Response<loginRequest>
                ) {
                    if (response.isSuccessful()) {
                        startActivity(intentPMC5)
                    } else {
                        when (response.code()) {
                            400 -> onFailure(call, Throwable())
                            404 -> onFailure(call, Throwable())
                            500 -> onFailure(call, Throwable())
                        }
                    }
                }

                override fun onFailure(call: Call<loginRequest>, t: Throwable) {
                    val dialog = AlertDialog.Builder(this@PMC2Activity)
                    dialog.setTitle("에러")
                    dialog.setMessage("호출실패했습니다.")
                    dialog.show()
                }
            })
        }

        binding.textViewFind.setOnClickListener {
            startActivity(intentPMC3)
        }
    }
}