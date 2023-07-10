package com.example.runworkshop.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.runworkshop.R
import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.core.RetrofitHelper.getRetrofit
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.data.model.InstitutoRepository
import com.example.runworkshop.data.model.InstitutoService
import com.example.runworkshop.data.model.network.InstitutoApiClient
import com.example.runworkshop.databinding.ActivityInstitutosBinding
import com.example.runworkshop.databinding.ActivityMainBinding
import com.example.runworkshop.ui.viewmodel.InstitutoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
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

        // insViewModel.onCreate()

    }

    private fun initUI() {
        binding.btnAPI.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<InstitutoModel>> = retrofit.create(InstitutoApiClient::class.java).getAllInstitutos()

                if (myResponse.isSuccessful) {
                    Log.i("DanielParada", "funciona :D")
                    val response = myResponse.body()
                    if(response != null){
                        Log.i("DanielParada", response.toString())
                    }
                } else {
                    Log.i("DanielParada", "No funciona :(")
                }
            }
        }
    }
}