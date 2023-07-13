package com.example.runworkshop.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.data.model.UniversidadModel
import com.example.runworkshop.data.model.network.UniversidadApiClient
import com.example.runworkshop.databinding.ActivityUniversidadesBinding
import com.example.runworkshop.ui.view.recyclerviews.UniversidadAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class UniversidadesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversidadesBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: UniversidadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = RetrofitHelper.getRetrofit()

        initUI()
    }

    private fun initUI() {
        binding.btnUniversidades.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<UniversidadModel>> =
                    retrofit.create(UniversidadApiClient::class.java).getAllUniversidades()
                val response = myResponse.body()
                if (response != null) {
                    runOnUiThread {
                        adapter.updateList(response)
                    }
                }
            }
        }
        adapter = UniversidadAdapter()
        binding.rvUniversidades.setHasFixedSize(true)
        binding.rvUniversidades.layoutManager = LinearLayoutManager(this)
        binding.rvUniversidades.adapter = adapter
    }
}