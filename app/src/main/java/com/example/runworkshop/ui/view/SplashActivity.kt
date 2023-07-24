package com.example.runworkshop.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.ui.view.auths.AuthActivity
import com.google.firebase.FirebaseApp

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Initialize Firebase
        FirebaseApp.initializeApp(this)

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        startActivity(Intent(this, AuthActivity::class.java))

    }

}