package com.example.runworkshop.data.model

import com.google.gson.annotations.SerializedName

//El modelo de la peticion json a convertir
data class InstitutoModel(
        @SerializedName("id") val id: Int,
        @SerializedName("note") val note: String,
)

/*
@SerializedName("instituto") val instituto: String,
@SerializedName("direccion") val direccion: String,
@SerializedName("taller") val taller: String,
@SerializedName("descripcion") val descripcion: String,
@SerializedName("fecha") val fecha: Int,
@SerializedName("hora") val hora: Int
*/
