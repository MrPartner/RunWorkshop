package com.example.runworkshop.domain.model

import com.example.runworkshop.data.model.UniversidadRepository
import com.example.runworkshop.data.model.database.entities.toDatabase
import javax.inject.Inject

class GetUniversidadesUseCase @Inject constructor(private val repository: UniversidadRepository) {

    suspend operator fun invoke():List<Universidad>{
        val universidades = repository.getAllUniversidadesFromApi()

        return if (universidades.isNotEmpty()){
            repository.clearUniversidades()
            repository.insertUniversidades(universidades.map { it.toDatabase() })
            universidades
        }else{
            repository.getAllUniversidadesFromDatabase()
        }
    }
}