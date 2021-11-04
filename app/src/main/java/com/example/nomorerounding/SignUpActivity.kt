package com.example.nomorerounding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc4)

        val Btn_signup = findViewById<Button>(R.id.btn_signup) as Button
        Btn_signup.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "가입되었습니다!", Toast.LENGTH_SHORT).show()
        })
    }
}