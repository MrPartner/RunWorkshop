package com.example.runworkshop.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.runworkshop.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)

        super.onCreate(savedInstanceState)
        startActivity(Intent(this,AuthActivity::class.java))

    }
}