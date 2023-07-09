package com.example.runworkshop.data.model

//Esta clase nos hace el llamado del caso de uso y ve de donde trae la informacion
//en este caso la trae de la api
class InstitutoRepository {

    private val api = InstitutoService()

    suspend fun getAllNotes():List<InstitutoModel>{
        val response = api.getInstituto(query = String())
        InstitutoProvider.institutos = response
        return response
    }
}