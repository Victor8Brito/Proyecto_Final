package com.example.proyectofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Pantalla_principal : Fragment() {
    lateinit var botonAdivinar: Button
    lateinit var botonRetrofit: Button
    lateinit var botonRecycler: Button
    lateinit var botonTablas: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_pantalla_principal, container, false)
        botonAdivinar = vista.findViewById(R.id.btnAdivinar)
        botonAdivinar.setOnClickListener {
            findNavController().navigate(R.id.action_pantalla_Principal_to_adivinaNunero)
        }
        botonTablas = vista.findViewById(R.id.btnTablas)
        botonTablas.setOnClickListener {
            findNavController().navigate(R.id.action_pantalla_principal_to_tablasDeMultiplicar)
        }
        botonRetrofit = vista.findViewById(R.id.btnRetrofit)
        botonRetrofit.setOnClickListener {
            findNavController().navigate(R.id.action_pantalla_principal_to_retrofit)
        }
        botonRecycler =vista.findViewById(R.id.btnRickMorty)
        botonRecycler.setOnClickListener {
            findNavController().navigate(R.id.action_pantalla_principal_to_recyclerView)
        }
        return vista
    }
}