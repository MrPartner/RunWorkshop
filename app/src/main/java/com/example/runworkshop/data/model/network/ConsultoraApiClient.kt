package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.ConsultoraModel
import retrofit2.Response
import retrofit2.http.GET

interface ConsultoraApiClient {

    @GET("/rwconsultoras")
    suspend fun getAllConsultoras():Response<List<ConsultoraModel>>
}