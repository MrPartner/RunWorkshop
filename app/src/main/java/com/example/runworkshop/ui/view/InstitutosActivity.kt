package com.example.runworkshop.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.runworkshop.R
import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.core.RetrofitHelper.getRetrofit
import com.example.runworkshop.databinding.ActivityInstitutosBinding
import com.example.runworkshop.databinding.ActivityMainBinding
import com.example.runworkshop.ui.viewmodel.InstitutoViewModel
import retrofit2.Retrofit

class InstitutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstitutosBinding
    private lateinit var retrofit: Retrofit

    private val insViewModel: InstitutoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstitutosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()

        /*insViewModel.insModel.observe(this, Observer {
            binding.rvInstitutos.text = it.note
        })*/

        //insViewModel.onCreate()



    }

    private fun initUI() {
        binding.rvInstitutos
    }
}