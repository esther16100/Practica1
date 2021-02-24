package com.esthermorales.practica1

import android.app.Application
import com.esthermorales.practica1.di.AppContainer

class Aplicacion : Application() {

    val appContainer = AppContainer(this)
}