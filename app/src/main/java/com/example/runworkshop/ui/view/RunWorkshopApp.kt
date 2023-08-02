package com.example.runworkshop.ui.view

import android.app.Application
import com.google.android.gms.ads.MobileAds
import dagger.hilt.android.HiltAndroidApp

//Instalamos dagger Hilt
@HiltAndroidApp
class RunWorkshopApp:Application(){

    //Inicializamos AdMob
    override fun onCreate(){
        super.onCreate()
        MobileAds.initialize(this)
    }

}

