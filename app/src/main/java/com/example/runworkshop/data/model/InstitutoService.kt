package com.example.runworkshop.data.model

import com.example.runworkshop.core.RetrofitHelper
import com.example.runworkshop.data.model.network.InstitutoApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

//Esta clase nos hace el llamado a retrofit para devolvernos el listado de la API
class InstitutoService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getInstituto(): List<InstitutoModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(InstitutoApiClient::class.java).getAllNotes()
            response.body() ?: emptyList()
        }

    }
}