package com.esthermorales.practica1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esthermorales.practica1.data.repositorio.CursosRepositorio
import com.esthermorales.practica1.domain.CourseModel
import kotlinx.coroutines.launch

class CursoDetalleViewModel(
    private val numeroSeminari: String,
    private val cursosRepositorio: CursosRepositorio
) : ViewModel() {

    private val _curso = MutableLiveData<CourseModel>()
    val curso: LiveData<CourseModel> = _curso

    init {
        viewModelScope.launch {
            val detalleCurso = cursosRepositorio.getDetalleCurso(numeroSeminari)
            _curso.postValue(detalleCurso)
        }
    }
}