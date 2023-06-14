package com.example.runworkshop.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.runworkshop.data.model.InstitutoModel

class InstitutoViewModel :ViewModel() {

    val insModel = MutableLiveData<InstitutoModel>()
}