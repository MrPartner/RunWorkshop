package com.example.runworkshop.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.runworkshop.domain.model.Consultora

@Entity(tableName = "consultoras")
data class ConsultoraEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "consultora") val consultora: String,
    @ColumnInfo(name = "direccion") val direccion: String,
    @ColumnInfo(name = "audiencia") val audiencia: String,
    @ColumnInfo(name = "taller") val taller: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "costo") val costo: String,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String,
)

fun Consultora.toDatabase() = ConsultoraEntity(
    consultora = consultora,
    direccion = direccion,
    audiencia = audiencia,
    taller = taller,
    descripcion = descripcion,
    costo = costo,
    fecha = fecha,
    hora = hora
)
