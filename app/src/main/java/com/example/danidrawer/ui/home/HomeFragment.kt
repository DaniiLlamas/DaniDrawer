package com.example.danidrawer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.danidrawer.OnInteractionListener
import com.example.danidrawer.Personaje
import com.example.danidrawer.PersonajesAdapter
import com.example.danidrawer.R
import com.example.danidrawer.databinding.FragmentHomeBinding
import com.example.danidrawer.viewmodel.Viewmodel

class HomeFragment : Fragment() {

    lateinit var listener: OnInteractionListener
    private lateinit var viewModel: Viewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(Viewmodel::class.java)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)
        setupRecyclerView(recyclerView)

        return view
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val adapter = PersonajesAdapter(viewModel.getPersonajes(), object : PersonajesAdapter.OnPersonajeClickListener {
            override fun onPersonajeClick(personaje: Personaje) {
                //Espacio para trabajar con el on Click
            }
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }




}