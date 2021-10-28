package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc2)

        val textview3: TextView = findViewById(R.id.textView3)
        textview3.setOnClickListener {
            val intent_pmc3 = Intent(this, MainActivity3::class.java)
            startActivity(intent_pmc3)
        }
    }
}