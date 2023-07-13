package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.UniversidadModel
import retrofit2.Response
import retrofit2.http.GET

interface UniversidadApiClient {

    @GET("/rwuniversidades")
    suspend fun getAllUniversidades(): Response<List<UniversidadModel>>
}