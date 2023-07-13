package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.InstitutoModel
import retrofit2.Response
import retrofit2.http.GET

//Esta interfaz hace el request GET a internet, el consumo de la API REST
interface InstitutoApiClient {
    @GET("/runworkshop")
    suspend fun getAllInstitutos(): Response<List<InstitutoModel>>

}