package com.example.runworkshop.data.model

import com.example.runworkshop.data.model.database.entities.UniversidadEntity
import com.example.runworkshop.data.model.database.entities.dao.UniversidadDao
import com.example.runworkshop.data.model.network.UniversidadService
import com.example.runworkshop.domain.model.Universidad
import com.example.runworkshop.domain.model.toDomain
import javax.inject.Inject

class UniversidadRepository @Inject constructor(
    private val api: UniversidadService,
    private val universidadDao: UniversidadDao
) {

    suspend fun getAllUniversidadesFromApi(): List<Universidad> {
        val response: List<UniversidadModel> = api.getUniversidad()
        return response.map { it.toDomain() }
    }

    suspend fun getAllUniversidadesFromDatabase(): List<Universidad>{
        val response: List<UniversidadEntity> = universidadDao.getAllUniversidades()
        return response.map { it.toDomain() }
    }

    suspend fun insertUniversidades(universidades:List<UniversidadEntity>){
        universidadDao.insertAllUniversidades(universidades)
    }

    suspend fun clearUniversidades(){
        universidadDao.deleteAllUniversidades()
    }
}