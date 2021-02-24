package com.esthermorales.practica1.data.model


import com.google.gson.annotations.SerializedName

data class Durada(
    @SerializedName("dies")
    val dies: String,
    @SerializedName("hores")
    val hores: String
)