package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyectofinal.adivinar.Juego

class AdivinaNunero : AppCompatActivity() {
    lateinit var b_iniciar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivina_nunero)

        b_iniciar = findViewById(R.id.b_inicio)
        b_iniciar.setOnClickListener {
            val AbrirJuego = Intent(this,Juego::class.java)
            startActivity(AbrirJuego)
        }
    }
}