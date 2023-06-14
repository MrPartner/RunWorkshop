package com.example.runworkshop.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Este objeto nos sirve para hacer el llamado a retrofit
object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}