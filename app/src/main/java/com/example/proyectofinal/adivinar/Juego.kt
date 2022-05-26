package com.example.proyectofinal.adivinar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyectofinal.R
import kotlin.random.Random

class Juego : AppCompatActivity() {
    lateinit var musicaFondo: MediaPlayer
    lateinit var respuestaUsuario: EditText
    lateinit var btnRespuesta: Button
    lateinit var sonidoRespuesta: MediaPlayer
    lateinit var sonidoRespuestaInc: MediaPlayer
    var numeroGenerado=0
    var numeroUsuario=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        initUI()
        musicaFondo = MediaPlayer.create(this, R.raw.parkle)
        sonidoRespuesta = MediaPlayer.create(this, R.raw.correcto)
        sonidoRespuestaInc = MediaPlayer.create(this, R.raw.incorrecto)
        reproducirMusica()
        generarNumero()

        btnRespuesta.setOnClickListener {
            val respuesta = respuestaUsuario.text.toString()
            if(respuesta.equals("")){
                Toast.makeText(this,"Ingresa un valor", Toast.LENGTH_LONG).show()
                sonidoIncorrecto()
            }else{
                numeroUsuario = respuesta.toInt()
                if (numeroGenerado == numeroUsuario){
                    sonidoCorrecto()
                }else{
                    sonidoIncorrecto()
                    Toast.makeText(this,"El valor era $numeroGenerado", Toast.LENGTH_SHORT).show()
                }
                generarNumero()
            }
        }
    }
    override fun onStop(){
        super.onStop()
        musicaFondo.release()
        sonidoRespuesta.release()
        sonidoRespuestaInc.release()
    }

    fun reproducirMusica(){
        musicaFondo.isLooping = true
        musicaFondo.setVolume(0.5f,0.5f)
        musicaFondo.start()
    }

    fun sonidoCorrecto(){
        sonidoRespuesta.start()
    }

    fun sonidoIncorrecto(){
        sonidoRespuestaInc.start()
    }

    fun initUI(){
        btnRespuesta = findViewById(R.id.b_empezar)
        respuestaUsuario = findViewById(R.id.respuesta)
    }

    fun generarNumero(){
        numeroGenerado= Random.nextInt(1,10)
        respuestaUsuario.text.clear()
    }
}