package com.esthermorales.practica1.ui.cursos

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.esthermorales.practica1.Aplicacion
import com.esthermorales.practica1.R
import com.esthermorales.practica1.databinding.FragmentCursosBinding

class CursosFragment : Fragment() {

    private lateinit var cursosViewModel: CursosViewModel
    private lateinit var binding: FragmentCursosBinding
    private lateinit var cursosAdapter: CursosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCursosBinding.inflate(inflater, container, false)
        inicializarRecyclerView()
        inicializarViewModel()
        return binding.root
    }

    private fun inicializarViewModel() {
        val appContainer = (activity?.application as Aplicacion).appContainer
        cursosViewModel = CursosViewModel(appContainer.cursosRepositorio)

        cursosViewModel.cursos.observe(viewLifecycleOwner, Observer {
            cursosAdapter.submitList(it)
        })
    }

    private fun inicializarRecyclerView() {
        binding.listacursos.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        cursosAdapter = CursosAdapter {
            navegarAlDetalle(it)
        }
        binding.listacursos.adapter = cursosAdapter

    }

    private fun navegarAlDetalle(numeroSeminari: String) {
        val action = CursosFragmentDirections.actionNavHomeToNavDetalle(numeroSeminari)
        findNavController().navigate(action)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(requireContext(), "settings", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_cursos, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


}