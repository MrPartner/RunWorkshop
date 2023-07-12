package com.example.runworkshop.data.model

import com.example.runworkshop.data.model.network.InstitutoService

//Esta clase se encarga de gestionar si accedemos a network o a database
//En este caso la trae de internet a travez de la clase InstitutoService
class InstitutoRepository {

    private val api = InstitutoService()

    suspend fun getAllInstitutos():List<InstitutoModel>{
        val response = api.getInstituto()
        InstitutoProvider.institutos = response
        return response
    }
}