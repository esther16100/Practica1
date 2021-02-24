package com.esthermorales.practica1.data.repositorio

import com.esthermorales.practica1.data.datasource.CursosLocalDataSource
import com.esthermorales.practica1.data.datasource.CursosRemoteDataSource
import com.esthermorales.practica1.domain.CourseModel

interface CursosRepositorio {
    suspend fun getCursos(): List<CourseModel>
    suspend fun getDetalleCurso(courseId: String): CourseModel
}

class CursosRepositorioImpl(
    private val cursosRemoteDataSource: CursosRemoteDataSource,
    private val cursosLocalDataSource: CursosLocalDataSource
) : CursosRepositorio {

    override suspend fun getCursos(): List<CourseModel> {
        val result = cursosLocalDataSource.getCursos()
        if (result.isEmpty()) {
            val cursos = cursosRemoteDataSource.getCursos()
            cursosLocalDataSource.insertCursos(cursos)
        }
        return cursosLocalDataSource.getCursos()
    }

    override suspend fun getDetalleCurso(courseId: String): CourseModel {
        return cursosLocalDataSource.getDetalle(courseId)
    }


}