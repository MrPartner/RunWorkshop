package com.example.runworkshop.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Aqui guardamos los datos de "manera local", como si fuera una base de datos local

@Singleton
class InstitutoProvider @Inject constructor() {
    var institutos: List<InstitutoModel> = emptyList()

}