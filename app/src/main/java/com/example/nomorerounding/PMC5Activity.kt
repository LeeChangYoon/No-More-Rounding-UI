package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.model.UserResponseDTO

class PMC5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pmc5)

        val intent: Intent = getIntent()
        var user: UserResponseDTO? = intent.getParcelableExtra("user")
    }
}