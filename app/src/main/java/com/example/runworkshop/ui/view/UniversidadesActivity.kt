package com.example.runworkshop.ui.view

import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runworkshop.R
import com.example.runworkshop.core.RetrofitHelper.getRetrofit
import com.example.runworkshop.data.model.UniversidadModel
import com.example.runworkshop.data.model.network.UniversidadApiClient
import com.example.runworkshop.databinding.ActivityUniversidadesBinding
import com.example.runworkshop.di.NetworkModule.provideUniversidadApiClient
import com.example.runworkshop.ui.view.recyclerviews.UniversidadAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

@AndroidEntryPoint
class UniversidadesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUniversidadesBinding
    private lateinit var api: UniversidadApiClient
    private lateinit var adapter: UniversidadAdapter
    private lateinit var retrofit: Retrofit

    //Interstitial
    private lateinit var preferences: SharedPreferences
    private var counter: Int = 0
    private var interstitial: InterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUniversidadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        retrofit = getRetrofit()
        api = provideUniversidadApiClient(retrofit)

        //iniciamos Banner
        initLoadAds()

        //iniciamos Interstitial
        initInterstitial()

        initUI()

        //sharedPreferences Interstitial
        preferences = getSharedPreferences("counter_prefs", MODE_PRIVATE)
        counter = preferences.getInt("counter", 0)

        //Atras/Interstitial
        binding.btnAtras.setOnClickListener {
            counter += 1
            checkCounter()
            onBackPressedDispatcher.onBackPressed()
        }
    }

    //sharedPreferences Interstitial
    override fun onPause() {
        super.onPause()
        val editor = preferences.edit()
        editor.putInt("counter", counter)
        editor.apply()
    }
    //sharedPreferences Interstitial
    override fun onResume() {
        super.onResume()
        counter = preferences.getInt("counter", 1)
    }

    //Esta funcion nos hace el llamado al consumo de la API
    private fun initUI() {
        binding.btnUniversidades.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<UniversidadModel>> =
                    api.getAllUniversidades()
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

    //iniciamos Banner
    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding.bannerUniversidades.loadAd(adRequest)
    }

    //iniciamos interstitial
    private fun initInterstitial() {
        var adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    interstitial = interstitialAd
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitial = null
                }
            })
    }

    //Interstitial
    private fun checkCounter() {
        if (counter == 2) {
            showInterstitial()
            counter = 0
            initInterstitial()
        }
    }

    //Interstitial
    private fun showInterstitial() {
        interstitial?.show(this)
    }

}