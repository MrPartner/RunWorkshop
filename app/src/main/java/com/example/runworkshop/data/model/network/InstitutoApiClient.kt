package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.InstitutoModel
import retrofit2.Response
import retrofit2.http.GET

//Esta interfaz nos sirve para hacer el request GET a internet
interface InstitutoApiClient {
    @GET("/notes")
    suspend fun getAllNotes(query: String):Response<List<InstitutoModel>>
}