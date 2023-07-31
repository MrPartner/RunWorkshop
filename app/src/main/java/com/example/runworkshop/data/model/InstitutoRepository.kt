package com.example.runworkshop.data.model

import com.example.runworkshop.data.model.database.entities.InstitutoEntity
import com.example.runworkshop.data.model.database.entities.dao.InstitutoDao
import com.example.runworkshop.data.model.network.InstitutoService
import com.example.runworkshop.domain.model.Instituto
import com.example.runworkshop.domain.model.toDomain
import javax.inject.Inject

//Esta clase se encarga de gestionar si accedemos a network o a database
//En este caso la trae de internet a travez de la clase InstitutoService
class InstitutoRepository @Inject constructor(
    private val api: InstitutoService,
    private val institutoDao: InstitutoDao
) {

    suspend fun getAllInstitutosFromApi(): List<Instituto> {
        val response: List<InstitutoModel> = api.getInstituto()
        return response.map { it.toDomain() }
    }

    suspend fun getAllInstitutosFromDatabase(): List<Instituto>{
        val response: List<InstitutoEntity> = institutoDao.getAllInstitutos()
        return response.map { it.toDomain() }
    }

    suspend fun insertInstitutos(institutos:List<InstitutoEntity>){
        institutoDao.insertAllInstitutos(institutos)
    }

    suspend fun clearInstitutos(){
        institutoDao.deleteAllInstitutos()
    }
}