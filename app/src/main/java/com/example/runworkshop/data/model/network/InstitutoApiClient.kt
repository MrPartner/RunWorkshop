package com.example.runworkshop.data.model.network

import com.example.runworkshop.data.model.InstitutoModel
import retrofit2.Response
import retrofit2.http.GET

interface InstitutoApiClient {
    @GET("/notes")
    suspend fun getAllNotes():Response<List<InstitutoModel>>
}