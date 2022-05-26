package com.example.proyectofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyectofinal.tablas.Practica

class TablasDeMultiplicar : AppCompatActivity() {
    lateinit var btnPracticar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablas_de_multiplicar)
        btnPracticar= findViewById(R.id.btnIrAPracticar)
        btnPracticar.setOnClickListener{
            val intentPracticar= Intent(this, Practica::class.java)
            startActivity(intentPracticar)
        }
    }
}