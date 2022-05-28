package com.example.proyectofinal.tablas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.proyectofinal.R

class ResultadoTablas : Fragment() {
    lateinit var  animView: LottieAnimationView
    lateinit var  btnRegresarAMultiplicacion: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_resultado_tablas, container, false)

        btnRegresarAMultiplicacion= vista.findViewById(R.id.btnRegresar)
        btnRegresarAMultiplicacion.setOnClickListener{
            findNavController().navigate(R.id.action_resultadoTablas_to_practica)
        }
        animView = vista.findViewById(R.id.animation_view)
        val result = arguments?.getBoolean("amount")
        if (result==true){
            animView.setAnimation(R.raw.success)
        }else{
            animView.setAnimation(R.raw.wrongnotif)
        }
        return vista
    }
}