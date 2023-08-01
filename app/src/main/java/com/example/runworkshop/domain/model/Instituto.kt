package com.example.runworkshop.domain.model


import com.example.runworkshop.data.model.InstitutoModel
import com.example.runworkshop.data.model.database.entities.InstitutoEntity

data class Instituto(
    val instituto: String,
    val direccion: String,
    val audiencia: String,
    val taller: String,
    val descripcion: String,
    val costo: String,
    val fecha: String,
    val hora: String,
)

fun InstitutoModel.toDomain() =
    Instituto(instituto, direccion, audiencia, taller, descripcion, costo, fecha, hora)

fun InstitutoEntity.toDomain() =
    Instituto(instituto, direccion, audiencia, taller, descripcion, costo, fecha, hora)
