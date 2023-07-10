package com.example.runworkshop.data.model

import com.google.gson.annotations.SerializedName

//El modelo de la peticion json a convertir
data class InstitutoModel(
    @SerializedName("instituto") val instituto: String,
    @SerializedName("direccion") val direccion: String,
    @SerializedName("taller") val taller: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("costo") val costo: String,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("hora") val hora: String
)




