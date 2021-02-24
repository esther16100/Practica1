package com.esthermorales.practica1.data.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("final")
    val final: String,
    @SerializedName("inici")
    val inici: String
)