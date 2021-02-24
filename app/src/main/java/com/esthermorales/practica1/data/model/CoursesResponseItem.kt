package com.esthermorales.practica1.data.model


import com.esthermorales.practica1.domain.CourseModel
import com.google.gson.annotations.SerializedName

data class CoursesResponseItem(
    @SerializedName("comentaris")
    val comentaris: String,
    @SerializedName("contacte")
    val contacte: Contacte,
    @SerializedName("data")
    val data: Data,
    @SerializedName("descripcio")
    val descripcio: String,
    @SerializedName("durada")
    val durada: Durada,
    @SerializedName("empresa_organitzadora")
    val empresaOrganitzadora: String,
    @SerializedName("hora")
    val hora: Hora,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("numero_seminari")
    val numeroSeminari: String,
    @SerializedName("places_reservades")
    val placesReservades: String,
    @SerializedName("titol")
    val titol: String,
    @SerializedName("ubicacio")
    val ubicacio: Ubicacio
)

fun CoursesResponseItem.mapToModel() : CourseModel {
    return CourseModel(
        id = this.numeroSeminari,
        titol = this.titol,
        logo = this.logo,
        empresaOrganitzadora = this.empresaOrganitzadora
    )
}