package com.example.runworkshop.ui.view.auths

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.runworkshop.R
import com.example.runworkshop.databinding.ActivityAuthBinding
import com.example.runworkshop.ui.view.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize Firebase
        FirebaseApp.initializeApp(this)

        //llamamos a la funcion setup
        setup()

    }

    //funcion de autenticacion
    private fun setup() {
        title = "Inicio"

        binding.btnRegistrar.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        binding.btnAcceder.setOnClickListener {
            if (binding.etEmail.text.isNotEmpty() && binding.etPassword.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        navigateToMainActivity(
                            it.result?.user?.email ?: "",
                            MainActivity.ProviderType.BASIC
                        )
                    } else {
                        showAlert()
                    }
                }
            }
        }

        binding.btnGoogle.setOnClickListener {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
            mAuth = FirebaseAuth.getInstance()
            mGoogleSignInClient.signOut()

            signInWithGoogle()
        }

    }

    //Funcion para el login de google
    private fun signInWithGoogle() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
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

    //funcion para navegar al MainActivity con parametros
    private fun navigateToMainActivity(email: String, provider: MainActivity.ProviderType) {
        val sesionIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(sesionIntent)
    }

    //Funcion para el login de google
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            // El inicio de sesión con Google fue exitoso, obtén la cuenta de Google
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                navigateToMainActivity(
                                    account.email ?: "",
                                    MainActivity.ProviderType.GOOGLE
                                )
                            } else {
                                showAlert()
                            }
                        }

                }
            } catch (e: ApiException) {
                showAlert()
            }
        }
    }


}