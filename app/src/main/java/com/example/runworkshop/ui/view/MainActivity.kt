package com.example.runworkshop.ui.view

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.R
import com.example.runworkshop.databinding.ActivityMainBinding
import com.example.runworkshop.ui.view.auths.AuthActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        binding.btnInstitutos.setOnClickListener { navigateToInstitutosActivity() }
        binding.btnUniversidades.setOnClickListener { navigateToUniversidadesActivity() }
        binding.btnConsultoras.setOnClickListener { navigateToConsultorasActivity() }

    }

    private fun setup(email: String, provider: String) {
        title = "Inicio"
        binding.tvEmail.text = email
        binding.tvProvider.text = provider
        binding.btnCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            navigateToAuthActivity()
        }
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

    private fun navigateToAuthActivity() {
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }

    enum class ProviderType{
        BASIC
    }

}

