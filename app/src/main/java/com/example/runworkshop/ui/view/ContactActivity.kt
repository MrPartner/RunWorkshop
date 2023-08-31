package com.example.runworkshop.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.R
import com.example.runworkshop.databinding.ActivityContactBinding

class ContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContactAtras.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}