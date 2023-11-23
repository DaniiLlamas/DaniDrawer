package com.example.danidrawer.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.danidrawer.Personaje

import com.example.danidrawer.R
import com.example.danidrawer.viewmodel.Viewmodel

class GalleryFragment : Fragment() {
    private lateinit var mvm: Viewmodel
    private lateinit var editTextNombre: EditText
    private lateinit var editTextNivel: EditText
    private lateinit var radioGroupArma: RadioGroup
    private lateinit var radioGroupElemento: RadioGroup
    private lateinit var btnAgregarPersonaje: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista: View = inflater.inflate(R.layout.fragment_gallery, container, false)
                                //Es requireActivity porque estoy en un fragment
                                //Si estoy en un activity uso this
        mvm = ViewModelProvider(requireActivity()).get(Viewmodel::class.java)

        //val datoObserver = Observer<Int>{
          //      numero -> etiqueta.text=numero.toString()
        //}
        // mvm.getDatoLiveData().observe(viewLifecycleOwner,datoObserver)
        editTextNombre = vista.findViewById(R.id.editTextNombre)
        editTextNivel = vista.findViewById(R.id.editTextNivel)
        radioGroupArma = vista.findViewById(R.id.radioGroupArma)
        radioGroupElemento = vista.findViewById(R.id.radioGroupElemento)
        btnAgregarPersonaje = vista.findViewById(R.id.btnAgregarPersonaje)

        btnAgregarPersonaje.setOnClickListener {
            agregarPersonaje()
        }


        return vista
    }

    private fun agregarPersonaje() {
        val nombre = editTextNombre.text.toString()
        val nivel = editTextNivel.text.toString().toIntOrNull()
        val idArmaSeleccionada = radioGroupArma.checkedRadioButtonId
        val idElementoSeleccionado = radioGroupElemento.checkedRadioButtonId

        if (nombre.isNotEmpty() && nivel != null && idArmaSeleccionada != -1 && idElementoSeleccionado != -1) {
            //Asi recojo los valores del RadioButton
            val radioButtonArma: RadioButton = view?.findViewById(idArmaSeleccionada) ?: return
            val radioButtonElemento: RadioButton = view?.findViewById(idElementoSeleccionado) ?: return

            val arma = radioButtonArma.text.toString()
            val elemento = radioButtonElemento.text.toString()


            val personaje = Personaje(nombre,nivel, elemento, arma)
            mvm.addPersonaje(personaje)

            // Limpia los campos después de agregar el personaje
            editTextNombre.text.clear()
            editTextNivel.text.clear()
            radioGroupArma.clearCheck()
            radioGroupElemento.clearCheck()

            // Notifico al usuario
            Toast.makeText(requireContext(), "Personaje agregado con éxito", Toast.LENGTH_SHORT).show()
            mvm.datoLiveData.value = mvm.datoLiveData.value!!+1

        } else {
            Toast.makeText(requireContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}