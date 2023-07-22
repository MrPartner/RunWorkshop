package com.example.runworkshop.ui.view

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.R
import com.example.runworkshop.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        binding.btnInstitutos.setOnClickListener { navigateToInstitutosActivity() }
        binding.btnUniversidades.setOnClickListener { navigateToUniversidadesActivity() }
        binding.btnConsultoras.setOnClickListener { navigateToConsultorasActivity() }

    }

    private fun navigateToInstitutosActivity() {
        val intent = Intent(this, InstitutosActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToUniversidadesActivity() {
        val intent = Intent(this, UniversidadesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToConsultorasActivity() {
        val intent = Intent(this, ConsultorasActivity::class.java)
        startActivity(intent)
    }

}

