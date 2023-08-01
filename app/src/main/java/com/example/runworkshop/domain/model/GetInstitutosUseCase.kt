package com.example.runworkshop.domain.model

import com.example.runworkshop.data.model.InstitutoRepository
import com.example.runworkshop.data.model.database.entities.toDatabase
import javax.inject.Inject

class GetInstitutosUseCase @Inject constructor(private val repository: InstitutoRepository) {

    suspend operator fun invoke():List<Instituto>?{
        val institutos = repository.getAllInstitutosFromApi()

        return if (institutos.isNotEmpty()){
            repository.clearInstitutos()
            repository.insertInstitutos(institutos.map { it.toDatabase() })
            institutos
        }else{
            repository.getAllInstitutosFromDatabase()
        }
    }
}