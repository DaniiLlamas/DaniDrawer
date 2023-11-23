package com.example.danidrawer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.danidrawer.Personaje

class Viewmodel: ViewModel() {

   var listaPersonaje: MutableList<Personaje> = mutableListOf()
    var datoLiveData : MutableLiveData<Int> = MutableLiveData(0)

    fun getDatoLiveData() : LiveData<Int> {
        return datoLiveData
    }
    fun addPersonaje(p:Personaje){
        listaPersonaje.add(p)
    }

    fun getPersonajes(): List<Personaje> {
        return listaPersonaje
    }

    fun buscarPersonajePorNombre(nombre: String): Personaje? {
        return listaPersonaje.find { it.nombre == nombre }
    }


}