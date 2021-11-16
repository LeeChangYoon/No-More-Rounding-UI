package com.example.nomorerounding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nomorerounding.databinding.Pmc2Binding

class MainActivity2 : AppCompatActivity() {

    private var mBinding: Pmc2Binding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = Pmc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView3.setOnClickListener{
            val intent_pmc3 = Intent(this, MainActivity3::class.java)
            startActivity(intent_pmc3)

        }

        binding.buttonSingin.setOnClickListener{
            val intent_pmc5 = Intent(this, MainActivity5::class.java)
            startActivity(intent_pmc5)
        }
    }
}