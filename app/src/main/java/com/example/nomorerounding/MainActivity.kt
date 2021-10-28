package com.example.nomorerounding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc1)

        val button_singin: Button = findViewById(R.id.button_singin)
        button_singin.setOnClickListener {
            val intent_pmc2 = Intent(this, MainActivity2::class.java)
            startActivity(intent_pmc2)
        }
    }
}