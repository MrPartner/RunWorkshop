package com.example.runworkshop.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.runworkshop.domain.model.Instituto

@Entity(tableName = "institutos")
data class InstitutoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "instituto") val instituto: String,
    @ColumnInfo(name = "direccion") val direccion: String,
    @ColumnInfo(name = "audiencia") val audiencia: String,
    @ColumnInfo(name = "taller") val taller: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "costo") val costo: String,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String,
)

fun Instituto.toDatabase() = InstitutoEntity(
    instituto = instituto,
    direccion = direccion,
    audiencia = audiencia,
    taller = taller,
    descripcion = descripcion,
    costo = costo,
    fecha = fecha,
    hora = hora
)