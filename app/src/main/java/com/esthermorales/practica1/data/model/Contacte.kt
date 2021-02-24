package com.esthermorales.practica1.data.model


import com.google.gson.annotations.SerializedName

data class Contacte(
    @SerializedName("carrec")
    val carrec: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("nom")
    val nom: String,
    @SerializedName("telefon")
    val telefon: String
)