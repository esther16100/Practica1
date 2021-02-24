package com.esthermorales.practica1.ui.detail

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.esthermorales.practica1.Aplicacion
import com.esthermorales.practica1.R
import com.esthermorales.practica1.databinding.FragmentDetalleBinding

class CursosDetalleFragment : Fragment(R.layout.fragment_detalle) {

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var cursoDetalleViewModel: CursoDetalleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        inicializarViewModel()
        binding.cursoDetalleNumeroSeminari.text =
            CursosDetalleFragmentArgs.fromBundle(requireArguments()).numeroSeminari
        return binding.root
    }


    private fun inicializarViewModel() {
        val appContainer = (activity?.application as Aplicacion).appContainer
        cursoDetalleViewModel = CursoDetalleViewModel(
            numeroSeminari = CursosDetalleFragmentArgs.fromBundle(requireArguments()).numeroSeminari,
            cursosRepositorio = appContainer.cursosRepositorio
        )

        cursoDetalleViewModel.curso.observe(viewLifecycleOwner, Observer {
            binding.cursoDetalleNumeroSeminari.text = it.id
            binding.cursoDetalleTitulo.text = it.titol
            binding.cursoDetalleEmpresa.text = it.empresaOrganitzadora

            Glide.with(binding.root.context)
                .load(it.logo)
                .into(binding.cursoDetalleLogo)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_curso_detalle, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_enviar -> {
                Toast.makeText(requireContext(), "Enviar", Toast.LENGTH_SHORT).show()
            }
            R.id.action_compartir -> {
                Toast.makeText(requireContext(), "Compartir", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}