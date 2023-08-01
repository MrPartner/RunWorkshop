package com.example.runworkshop.data.model

import com.example.runworkshop.data.model.database.entities.ConsultoraEntity
import com.example.runworkshop.data.model.database.entities.dao.ConsultoraDao
import com.example.runworkshop.data.model.network.ConsultoraService
import com.example.runworkshop.domain.model.Consultora
import com.example.runworkshop.domain.model.toDomain
import javax.inject.Inject

class ConsultoraRepository @Inject constructor(
    private val api: ConsultoraService,
    private val consultoraDao: ConsultoraDao
) {

    suspend fun getAllConsultorasFromApi(): List<Consultora> {
        val response: List<ConsultoraModel> = api.getConsultora()
        return response.map { it.toDomain() }
    }

    suspend fun getAllConsultorasFromDatabase(): List<Consultora>{
        val response: List<ConsultoraEntity> = consultoraDao.getAllConsultoras()
        return response.map { it.toDomain() }
    }

    suspend fun insertConsultoras(consultoras:List<ConsultoraEntity>){
        consultoraDao.insertAllConsultoras(consultoras)
    }

    suspend fun clearConsultoras(){
        consultoraDao.deleteAllConsultoras()
    }
}