package com.example.runworkshop.data.model

class InstitutoRepository {

    private val api = InstitutoService()

    suspend fun getAllNotes():List<InstitutoModel>{
        val response = api.getInstituto()
        InstitutoProvider.institutos = response
        return response
    }
}