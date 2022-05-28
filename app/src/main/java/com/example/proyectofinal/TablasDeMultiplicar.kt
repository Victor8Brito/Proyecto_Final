package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.tablas.Practica

class TablasDeMultiplicar : Fragment() {
    lateinit var btnPracticar:Button
    lateinit var btnregresar:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_tablas_de_multiplicar, container, false)
        btnregresar= vista.findViewById(R.id.btnHome2)
        btnregresar.setOnClickListener {
            findNavController().navigate(R.id.action_tablasDeMultiplicar_to_pantalla_principal)
        }
        btnPracticar= vista.findViewById(R.id.btnIrAPracticar)
        btnPracticar.setOnClickListener {
            findNavController().navigate(R.id.action_tablasDeMultiplicar_to_practica)
        }
        return vista

    }

}