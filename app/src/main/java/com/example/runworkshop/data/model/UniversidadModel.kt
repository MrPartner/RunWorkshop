package com.example.runworkshop.data.model

import com.google.gson.annotations.SerializedName

data class UniversidadModel(
    @SerializedName("universidad") val universidad: String,
    @SerializedName("direccion") val direccion: String,
    @SerializedName("audiencia") val audiencia: String,
    @SerializedName("taller") val taller: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("costo") val costo: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("hora") val hora: String
)
