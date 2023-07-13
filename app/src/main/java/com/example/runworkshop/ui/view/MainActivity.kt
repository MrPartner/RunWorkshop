package com.example.runworkshop.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.runworkshop.core.RetrofitHelper.getRetrofit
import com.example.runworkshop.databinding.ActivityMainBinding
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.ui.viewmodel.InstitutoViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

