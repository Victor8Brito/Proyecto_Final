package com.example.proyectofinal.rickandmorty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.R
import com.squareup.picasso.Picasso

class AdaptadorPersonaje(val listaPersonajes:ArrayList<Personaje>): RecyclerView.Adapter<AdaptadorPersonaje.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vista_personajes,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Nombre.text = listaPersonajes[position].nombre
        Picasso.get()
            .load(listaPersonajes[position].imagen)
            .into(holder.Imagen)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    class ViewHolder(visualizar: View): RecyclerView.ViewHolder(visualizar){
        val Nombre: TextView
        val Imagen: ImageView

        init {
            Nombre = visualizar.findViewById(R.id.tvNombre)
            Imagen = visualizar.findViewById(R.id.ImagenPersonaje)
        }
    }
}