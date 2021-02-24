package com.esthermorales.practica1.ui.cursos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.esthermorales.practica1.data.model.CoursesResponseItem
import com.esthermorales.practica1.databinding.ItemCursoBinding
import com.esthermorales.practica1.domain.CourseModel

class CursosAdapter(private val onClick: (String) -> Unit) :
    ListAdapter<CourseModel, CursoViewholder>(CursosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewholder {
        val itemBinding =
            ItemCursoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CursoViewholder(itemBinding)
    }

    override fun onBindViewHolder(holder: CursoViewholder, position: Int) {
        holder.bind(getItem(position), onClick)
    }

}

class CursoViewholder(private val binding: ItemCursoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: CourseModel, onClick: (String) -> Unit) {
        binding.itemCursoNumeroSeminari.text = item.id
        binding.itemCursoEmpresa.text = item.empresaOrganitzadora
        binding.itemCursoTitulo.text = item.titol

        Glide.with(binding.root.context)
            .load(item.logo)
            .into(binding.itemCursoLogo)

        binding.root.setOnClickListener {
            onClick.invoke(item.id)
        }
    }

}

class CursosDiffCallback : DiffUtil.ItemCallback<CourseModel>() {
    override fun areItemsTheSame(
        oldItem: CourseModel,
        newItem: CourseModel
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: CourseModel,
        newItem: CourseModel
    ): Boolean = oldItem == newItem

}