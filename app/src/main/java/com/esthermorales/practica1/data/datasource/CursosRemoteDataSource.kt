package com.esthermorales.practica1.data.datasource

import com.esthermorales.practica1.data.model.CoursesResponse
import com.esthermorales.practica1.data.retrofit.CursoServicio

interface CursosRemoteDataSource {
    suspend fun getCursos(): CoursesResponse
}

class CursosRemoteDataSourceImpl(private val cursosServicio: CursoServicio) :
    CursosRemoteDataSource {

    override suspend fun getCursos(): CoursesResponse {
        return cursosServicio.getCursos()
    }
}