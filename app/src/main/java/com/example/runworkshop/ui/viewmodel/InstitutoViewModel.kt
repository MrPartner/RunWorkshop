package com.example.runworkshop.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.domain.GetInstitutosUseCase
import kotlinx.coroutines.launch

class InstitutoViewModel :ViewModel() {

    private val insModel = MutableLiveData<InstitutoModel>()

    var getInstitutosUseCase = GetInstitutosUseCase()
    fun onCreate() {
        viewModelScope.launch {
            val result = getInstitutosUseCase()

            if(!result.isNullOrEmpty()){
                insModel.postValue(result[1])
            }
        }
    }
}