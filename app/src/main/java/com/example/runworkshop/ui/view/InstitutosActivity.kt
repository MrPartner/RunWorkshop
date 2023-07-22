package com.example.runworkshop.ui.view

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runworkshop.R
import com.example.runworkshop.core.RetrofitHelper.getRetrofit
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.data.model.network.InstitutoApiClient
import com.example.runworkshop.databinding.ActivityInstitutosBinding
import com.example.runworkshop.ui.view.recyclerviews.InstitutoAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class InstitutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstitutosBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: InstitutoAdapter

    //private val insViewModel: InstitutoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstitutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        retrofit = getRetrofit()

        initUI()
    }

    //Esta funcion nos hace el llamado al consumo de la API
    private fun initUI() {
        binding.btnInstitutos.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<InstitutoModel>> =
                    retrofit.create(InstitutoApiClient::class.java).getAllInstitutos()
                val response = myResponse.body()
                if (response != null) {
                    runOnUiThread {
                        adapter.updateList(response)
                    }
                }
            }
        }
        adapter = InstitutoAdapter()
        binding.rvInstitutos.setHasFixedSize(true)
        binding.rvInstitutos.layoutManager = LinearLayoutManager(this)
        binding.rvInstitutos.adapter = adapter
    }
}
//Como creamos un test de consumo con Log
/*
//  if (myResponse.isSuccessful) {
                 //   Log.i("DanielParada", "funciona :D")
                    val response = myResponse.body()
                    if(response != null){
                     //   Log.i("DanielParada", response.toString())
                        runOnUiThread {
                            adapter.updateList(response)
                        }
                    }
             //   } else {
                  //  Log.i("DanielParada", "No funciona :(")
              //  }
 */