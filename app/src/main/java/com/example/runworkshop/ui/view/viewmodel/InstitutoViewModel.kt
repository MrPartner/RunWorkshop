package com.example.runworkshop.ui.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.domain.model.GetInstitutosUseCase
import com.example.runworkshop.domain.model.Instituto
import com.example.runworkshop.ui.view.recyclerviews.InstitutoAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class InstitutoViewModel @Inject constructor(
    private val getInstitutosUseCase: GetInstitutosUseCase
) : ViewModel() {

    val institutoModel = MutableLiveData<Instituto>()


    fun onCreate() {
        viewModelScope.launch {

        }
    }



}