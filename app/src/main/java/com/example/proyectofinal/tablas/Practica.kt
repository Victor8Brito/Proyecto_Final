package com.example.proyectofinal.tablas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.R
import kotlin.random.Random

class Practica : Fragment() {
    lateinit var tvFactor1: TextView
    lateinit var tvFactor2: TextView
    lateinit var etRespuesta: EditText
    lateinit var btnVerificar: Button
    lateinit var btnRegresarIni: Button
    var factor1:Int=0
    var factor2:Int=0
    var producto:Int=0
    var respuestaCorrecta=false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_practica, container, false)
        tvFactor1=vista.findViewById(R.id.tvFactor1)
        tvFactor2=vista.findViewById(R.id.tvFactor2)
        etRespuesta=vista.findViewById(R.id.etRespuesta)
        btnVerificar=vista.findViewById(R.id.btnVerificar)
        initUI()


        btnVerificar.setOnClickListener{
            val strRespuesta= etRespuesta.text.toString()
            if(strRespuesta.equals("")){
                Toast.makeText(activity,"Dejaste el campo vacío", Toast.LENGTH_LONG).show()
            }else{
                respuestaCorrecta=producto==strRespuesta.toInt()
                val bundle = bundleOf("amount" to respuestaCorrecta)
                generaMultiplicacion()
                findNavController().navigate(R.id.action_practica_to_resultadoTablas, bundle)
            }
        }

        btnRegresarIni= vista.findViewById(R.id.btnRegresarInicio)
        btnRegresarIni.setOnClickListener{
            findNavController().navigate(R.id.action_practica_to_tablasDeMultiplicar)
        }
        return vista
    }

    fun initUI(){
        generaMultiplicacion()
    }

    fun generaMultiplicacion(){
        factor1= Random.nextInt(0,10)
        factor2= Random.nextInt(0,10)
        producto= factor1*factor2
        tvFactor1.text="$factor1"
        tvFactor2.text="$factor2"
        etRespuesta.text.clear()
    }
}