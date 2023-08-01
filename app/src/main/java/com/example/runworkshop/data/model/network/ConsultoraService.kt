package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.ConsultoraModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ConsultoraService @Inject constructor(private val api:ConsultoraApiClient) {
    suspend fun getConsultora(): List<ConsultoraModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllConsultoras()
            response.body() ?: emptyList()
        }
    }

}