package com.example.runworkshop.domain.model

import com.example.runworkshop.data.model.ConsultoraRepository
import com.example.runworkshop.data.model.database.entities.toDatabase
import javax.inject.Inject

class GetConsultorasUseCase @Inject constructor(private val repository: ConsultoraRepository) {

    suspend operator fun invoke():List<Consultora>{
        val consultoras = repository.getAllConsultorasFromApi()

        return if (consultoras.isNotEmpty()){
            repository.clearConsultoras()
            repository.insertConsultoras(consultoras.map { it.toDatabase() })
            consultoras
        }else{
            repository.getAllConsultorasFromDatabase()
        }
    }
}