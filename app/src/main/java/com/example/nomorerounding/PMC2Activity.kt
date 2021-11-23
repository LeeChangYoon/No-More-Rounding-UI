package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.databinding.Pmc2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.nomorerounding.User.server
import com.example.nomorerounding.model.SignInRequestDTO
import com.example.nomorerounding.model.UserResponseDTO

class PMC2Activity : AppCompatActivity() {
    private var _binding: Pmc2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = Pmc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val ID: EditText = findViewById(R.id.textInputEditText_id)
        val PASSWORD: EditText = findViewById(R.id.textInputEditText_password)

        val intentPMC3 = Intent(this, PMC3Activity::class.java)
        val intentPMC5 = Intent(this, PMC5Activity::class.java)

        binding.buttonSignin.setOnClickListener {
            val loginId = ID.text.toString()
            val password = PASSWORD.text.toString()

            server.requestLogin(SignInRequestDTO(loginId, password)).enqueue(object : Callback<UserResponseDTO> {
                override fun onResponse(
                    call: Call<UserResponseDTO>,
                    response: Response<UserResponseDTO>
                ) {
                    if (response.isSuccessful()) {
                        val user: UserResponseDTO? = response.body()
                        intentPMC5.putExtra("user", user)
                        startActivity(intentPMC5)
                    } else {
                        when (response.code()) {
                            400 -> onFailure(call, Throwable())
                            404 -> onFailure(call, Throwable())
                            500 -> onFailure(call, Throwable())
                        }
                    }
                }

                override fun onFailure(call: Call<UserResponseDTO>, t: Throwable) {
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
