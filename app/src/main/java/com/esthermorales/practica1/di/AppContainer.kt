package com.esthermorales.practica1.di

import android.content.Context
import com.esthermorales.practica1.data.datasource.CursosLocalDataSource
import com.esthermorales.practica1.data.datasource.CursosLocalDataSourceImpl
import com.esthermorales.practica1.data.datasource.CursosRemoteDataSource
import com.esthermorales.practica1.data.datasource.CursosRemoteDataSourceImpl
import com.esthermorales.practica1.data.repositorio.CursosRepositorio
import com.esthermorales.practica1.data.repositorio.CursosRepositorioImpl
import com.esthermorales.practica1.data.retrofit.CursoServicio
import com.esthermorales.practica1.data.room.CoursesDao
import com.esthermorales.practica1.data.room.CoursesDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(private val context: Context) {

    private val baseURL = "http://www.xtec.cat/~jmendez1/forteco/"
    private val cursoServicio: CursoServicio
        get() {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CursoServicio::class.java)
        }

    private val localDataSource: CursosLocalDataSource
        get() = CursosLocalDataSourceImpl(coursesDao)

    private val remoteDataSource: CursosRemoteDataSource
        get() = CursosRemoteDataSourceImpl(cursoServicio)

    val cursosRepositorio: CursosRepositorio
        get() = CursosRepositorioImpl(remoteDataSource, localDataSource)

    val coursesDao: CoursesDao
        get() = CoursesDatabase.getInstance(context).coursesDao

}