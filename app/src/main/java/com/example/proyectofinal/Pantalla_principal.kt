package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
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
            findNavController().navigate(R.id.action_pantalla_principal_to_adivinaNunero)
        }
        return vista
    }
}