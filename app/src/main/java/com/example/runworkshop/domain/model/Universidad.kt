package com.example.runworkshop.domain.model

import com.example.runworkshop.data.model.UniversidadModel
import com.example.runworkshop.data.model.database.entities.UniversidadEntity

data class Universidad(
    val universidad: String,
    val direccion: String,
    val audiencia: String,
    val taller: String,
    val descripcion: String,
    val costo: String,
    val fecha: String,
    val hora: String,
)

fun UniversidadModel.toDomain() =
    Universidad(universidad, direccion, audiencia, taller, descripcion, costo, fecha, hora)

fun UniversidadEntity.toDomain() =
    Universidad(universidad, direccion, audiencia, taller, descripcion, costo, fecha, hora)
