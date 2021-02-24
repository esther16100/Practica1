package com.esthermorales.practica1.data.datasource

import com.esthermorales.practica1.data.model.CoursesResponse
import com.esthermorales.practica1.data.room.CoursesDao
import com.esthermorales.practica1.data.room.Curso
import com.esthermorales.practica1.data.room.toModel
import com.esthermorales.practica1.domain.CourseModel

interface CursosLocalDataSource {
    suspend fun getCursos(): List<CourseModel>
    suspend fun getDetalle(courseId: String): CourseModel
    suspend fun insertCursos(courseResponse: CoursesResponse)
}

class CursosLocalDataSourceImpl(private val coursesDao: CoursesDao) : CursosLocalDataSource {

    override suspend fun getCursos(): List<CourseModel> {
        return coursesDao.getAllCursos().map { it.toModel() }
    }

    override suspend fun getDetalle(courseId: String): CourseModel {
        return coursesDao.getCurso(courseId).toModel()
    }

    override suspend fun insertCursos(courseResponse: CoursesResponse) {
        courseResponse.map {
            coursesDao.insert(
                Curso(
                    numeroSeminari = it.numeroSeminari,
                    logo = it.logo,
                    titol = it.titol,
                    empresaOrganitzadora = it.empresaOrganitzadora
                )
            )
        }
    }

}