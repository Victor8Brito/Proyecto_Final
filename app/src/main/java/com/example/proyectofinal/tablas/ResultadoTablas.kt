package com.example.proyectofinal.tablas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView
import com.example.proyectofinal.R

class ResultadoTablas : AppCompatActivity() {
    lateinit var  animView: LottieAnimationView
    lateinit var  btnRegresarAMultiplicacion: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_tablas)

        btnRegresarAMultiplicacion= findViewById(R.id.btnRegresar)
        btnRegresarAMultiplicacion.setOnClickListener{
            val intentMultiplicacion= Intent(this,Practica::class.java)
            startActivity(intentMultiplicacion)
        }

        animView = findViewById(R.id.animation_view)

        val extras = intent.extras
        val respuestaCorrecta = extras!!.getBoolean("respuesta")
        if (respuestaCorrecta){
            animView.setAnimation(R.raw.success)
        }else{
            animView.setAnimation(R.raw.wrongnotif)
        }
    }
}