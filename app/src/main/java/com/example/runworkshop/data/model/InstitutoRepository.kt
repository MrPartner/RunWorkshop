package com.example.runworkshop.data.model

import com.example.runworkshop.data.model.network.InstitutoService
import javax.inject.Inject

//Esta clase se encarga de gestionar si accedemos a network o a database
//En este caso la trae de internet a travez de la clase InstitutoService
class InstitutoRepository @Inject constructor(
    private val api: InstitutoService,
    private val institutoProvider: InstitutoProvider
) {

    suspend fun getAllInstitutos(): List<InstitutoModel> {
        val response = api.getInstituto()
        institutoProvider.institutos = response
        return response
    }

}