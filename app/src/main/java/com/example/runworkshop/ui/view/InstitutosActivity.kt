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
import com.example.runworkshop.di.NetworkModule.provideInstitutoApiClient
import com.example.runworkshop.ui.view.recyclerviews.InstitutoAdapter
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
class InstitutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInstitutosBinding
    private lateinit var adapter: InstitutoAdapter
    private lateinit var retrofit: Retrofit
    private lateinit var api: InstitutoApiClient

    //Interstitial
    private var counter: Int = 0
    private var interstitial: InterstitialAd? = null

    //private val institutoViewModel : InstitutoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstitutosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.blue)))

        retrofit = getRetrofit()
        api = provideInstitutoApiClient(retrofit)

        //institutoViewModel.onCreate()

        /*institutoViewModel.institutoModel.observe(this, Observer {

        })*/

        //iniciamos Banner
        initLoadAds()

        //iniciamos Interstitial
        initInterstitial()

        initUI()

        //Atras/Interstitial
        binding.btnAtras.setOnClickListener {
            counter += 1
            checkCounter()
            onBackPressedDispatcher.onBackPressed()
        }
    }

    //Esta funcion nos hace el llamado al consumo de la API
    private fun initUI() {
        binding.btnInstitutos.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val myResponse: Response<List<InstitutoModel>> =
                    api.getAllInstitutos()
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

    //iniciamos Banner
    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding.bannerInstitutos.loadAd(adRequest)
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
