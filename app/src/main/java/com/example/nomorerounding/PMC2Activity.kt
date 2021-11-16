package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.databinding.Pmc2Binding


class PMC2Activity : AppCompatActivity() {
    private var _binding: Pmc2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = Pmc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val ID: EditText = findViewById(R.id.textInputEditText_id)
        val Password: EditText = findViewById(R.id.textInputEditText_password)

        val textViewFind: TextView = findViewById(R.id.textView_find)
        val buttonSignIn: Button = findViewById(R.id.button_signin)

        val intentPMC3 = Intent(this, PMC3Activity::class.java)
        val intentPMC5 = Intent(this, PMC5Activity::class.java)

        binding.textViewFind.setOnClickListener {
            startActivity(intentPMC3)
        }

        binding.buttonSignin.setOnClickListener {
            startActivity(intentPMC5)
        }
    }
}