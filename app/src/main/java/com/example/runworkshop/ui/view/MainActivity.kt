package com.example.runworkshop.ui.view

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
    private lateinit var retrofit: Retrofit

    private val insViewModel : InstitutoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

        insViewModel.insModel.observe(this, Observer {
            binding.tvInsitutos.text = it.note
        })
    }

    private fun initUI() {

    }

}

