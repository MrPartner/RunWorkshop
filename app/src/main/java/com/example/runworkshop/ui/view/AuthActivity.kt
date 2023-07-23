package com.example.runworkshop.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.runworkshop.databinding.ActivityAuthBinding
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setup, autenticacion
        setup()
    }

    //funcion de autenticacion
    private fun setup() {
        title = "Inicio"

        binding.btnRegistrar.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this, "USUARIO REGISTRADO SATISFACTORIAMENTE", Toast.LENGTH_LONG).show()
                    }else{
                        showAlert()
                    }
                }
            }
        }

        binding.btnAcceder.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful){
                        navigateToMainActivity(it.result?.user?.email ?: "", MainActivity.ProviderType.BASIC)
                    }else{
                        Toast.makeText(this, "ERROR AL INGRESAR, COMPRUEBE SUS DATOS", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }

    //funcion en caso de que haya error en el login btnSignUp
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    private fun navigateToMainActivity(email:String, provider: MainActivity.ProviderType) {
        val sesionIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(sesionIntent)
    }


}