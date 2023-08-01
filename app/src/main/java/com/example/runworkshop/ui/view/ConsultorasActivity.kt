package com.example.runworkshop.ui.view

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runworkshop.R
import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.data.model.ConsultoraModel
import com.example.runworkshop.data.model.network.ConsultoraApiClient
import com.example.runworkshop.databinding.ActivityConsultorasBinding
import com.example.runworkshop.ui.view.recyclerviews.ConsultoraAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

@AndroidEntryPoint
class ConsultorasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConsultorasBinding
    private lateinit var api:ConsultoraApiClient
    private lateinit var adapter: ConsultoraAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultorasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        initUI()
    }

    private fun initUI() {
        binding.btnConsultoras.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<ConsultoraModel>> =
                    api.getAllConsultoras()
                val response = myResponse.body()
                if (response != null) {
                    runOnUiThread {
                        adapter.updateList(response)
                    }
                }
            }
        }

        adapter = ConsultoraAdapter()
        binding.rvConsultoras.setHasFixedSize(true)
        binding.rvConsultoras.layoutManager = LinearLayoutManager(this)
        binding.rvConsultoras.adapter = adapter
    }
}