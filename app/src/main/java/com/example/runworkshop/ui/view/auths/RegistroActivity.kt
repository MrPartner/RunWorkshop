package com.example.runworkshop.ui.view.auths

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.runworkshop.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registrar()
    }

    private fun registrar() {
        binding.btnRegistrarRegistro.setOnClickListener {
            if (binding.etEmailRegistro.text.isNotEmpty() && binding.etPasswordRegistro.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.etEmailRegistro.text.toString(),
                    binding.etPasswordRegistro.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(
                            this,
                            "USUARIO REGISTRADO SATISFACTORIAMENTE",
                            Toast.LENGTH_LONG
                        ).show()
                        onBackPressed()
                    } else {
                        showAlert()
                    }
                }
            }
        }
    }


    //funcion en caso de que haya error en el login btnSignUp
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}