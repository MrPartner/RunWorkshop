package com.example.runworkshop.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.R
import com.example.runworkshop.databinding.ActivityTerminosCondicionesBinding

class TerminosCondicionesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTerminosCondicionesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerminosCondicionesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAceptar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}