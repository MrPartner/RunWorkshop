package com.example.runworkshop.data.model

//Aqui guardamos los datos de "manera local", como si fuera una base de datos local
class InstitutoProvider {
    companion object{
        var institutos:List<InstitutoModel> = emptyList()
    }
}