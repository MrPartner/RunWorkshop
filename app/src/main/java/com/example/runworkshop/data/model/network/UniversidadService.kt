package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.ConsultoraModel
import com.example.runworkshop.data.model.UniversidadModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UniversidadService @Inject constructor(private val api:UniversidadApiClient) {
    suspend fun getUniversidad(): List<UniversidadModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllUniversidades()
            response.body() ?: emptyList()
        }
    }

}