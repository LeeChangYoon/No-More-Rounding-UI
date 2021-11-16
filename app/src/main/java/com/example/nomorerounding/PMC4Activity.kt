package com.example.nomorerounding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class PMC4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc4)

        val buttonSingUp: Button = findViewById(R.id.button_signup)

        val intentMain = Intent(this, MainActivity::class.java)

        buttonSingUp.setOnClickListener{
            Toast.makeText(this, "가입되었습니다!", Toast.LENGTH_SHORT).show()
            startActivity(intentMain)
        }
    }
}