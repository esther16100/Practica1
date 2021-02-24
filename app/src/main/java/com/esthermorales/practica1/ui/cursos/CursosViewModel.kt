package com.esthermorales.practica1.ui.cursos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esthermorales.practica1.data.repositorio.CursosRepositorio
import com.esthermorales.practica1.domain.CourseModel
import kotlinx.coroutines.launch

class CursosViewModel(private val cursosRepositorio: CursosRepositorio) : ViewModel() {

    private val _cursos = MutableLiveData<List<CourseModel>>()
    val cursos: LiveData<List<CourseModel>> = _cursos

    init {
        viewModelScope.launch {
            _cursos.postValue(cursosRepositorio.getCursos())
        }
    }
}