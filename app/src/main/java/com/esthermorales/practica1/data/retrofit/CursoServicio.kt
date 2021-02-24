package com.esthermorales.practica1.data.retrofit

import com.esthermorales.practica1.data.model.CoursesResponse
import retrofit2.http.GET

interface CursoServicio {

    @GET("courses.json")
    suspend fun getCursos() : CoursesResponse
}