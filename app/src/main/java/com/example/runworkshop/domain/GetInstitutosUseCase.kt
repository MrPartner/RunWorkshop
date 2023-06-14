package com.example.runworkshop.domain

import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.data.model.InstitutoRepository

//Esta clase nos permite realizar los casos de uso
class GetInstitutosUseCase {

    private val repository = InstitutoRepository()

    suspend operator fun invoke():List<InstitutoModel>?{
        return repository.getAllNotes()
    }
}