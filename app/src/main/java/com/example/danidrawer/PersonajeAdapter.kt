package com.example.danidrawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.danidrawer.databinding.ItemPersonajeBinding

class PersonajesAdapter(
    private val personajes: List<Personaje>,
    private val listener: OnPersonajeClickListener
) : RecyclerView.Adapter<PersonajesAdapter.ViewHolder>() {

    interface OnPersonajeClickListener {
        fun onPersonajeClick(personaje: Personaje)
    }

    inner class ViewHolder(private val binding: ItemPersonajeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(personaje: Personaje) {
            binding.textViewNombre.text = personaje.nombre
            binding.textViewNivel.text = "Nivel: ${personaje.nivel}"
            binding.textViewElemento.text = "Elemento: ${personaje.elemento}"
            binding.textViewArma.text ="Arma: ${personaje.arma}"
            binding.root.setOnClickListener { listener.onPersonajeClick(personaje) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPersonajeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = personajes[position]
        holder.bind(personaje)
    }

    override fun getItemCount(): Int {
        return personajes.size
    }
}
