package com.example.runworkshop.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginGoogleViewModel:ViewModel() {
    private val auth:FirebaseAuth = Firebase.auth

}