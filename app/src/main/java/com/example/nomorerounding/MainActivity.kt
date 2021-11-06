package com.example.nomorerounding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc1)

        val button_singin: Button = findViewById(R.id.button_singin)
        val textView_signup: TextView = findViewById(R.id.textView_signup)

        button_singin.setOnClickListener {
            val intent_pmc2 = Intent(this, MainActivity2::class.java)
            startActivity(intent_pmc2)
        }

        textView_signup.setOnClickListener {
            val intent_pmc4 = Intent(this, SignUpActivity::class.java)
            startActivity(intent_pmc4)
        }
    }
}