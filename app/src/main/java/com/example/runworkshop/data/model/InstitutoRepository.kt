package com.example.runworkshop.data.model

//Esta clase nos hace el llamado del caso de uso y ve de donde trae la informacion
//en este caso la trae de retrofit con la API
class InstitutoRepository {

    private val api = InstitutoService()

    suspend fun getAllInstitutos():List<InstitutoModel>{
        val response = api.getInstituto()
        InstitutoProvider.institutos = response
        return response
    }
}