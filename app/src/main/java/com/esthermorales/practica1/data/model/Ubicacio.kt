package com.esthermorales.practica1.data.model


import com.google.gson.annotations.SerializedName

data class Ubicacio(
    @SerializedName("adreca")
    val adreca: String,
    @SerializedName("centre")
    val centre: String,
    @SerializedName("ciutat")
    val ciutat: String,
    @SerializedName("cp")
    val cp: String,
    @SerializedName("provincia")
    val provincia: String
)