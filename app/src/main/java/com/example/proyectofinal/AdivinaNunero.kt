package com.example.proyectofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AdivinaNunero : Fragment() {
    lateinit var b_iniciar: Button
    lateinit var b_home1:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_adivina_nunero, container, false)
        b_iniciar = vista.findViewById(R.id.b_inicio)
        b_iniciar.setOnClickListener {
            findNavController().navigate(R.id.action_adivinaNunero_to_juego)
        }

        b_home1 = vista.findViewById(R.id.btnHome1)
        b_home1.setOnClickListener {
            findNavController().navigate(R.id.action_adivinaNunero_to_pantalla_Principal)
        }
        return vista
    }
}