package com.example.proyectofinal.adivinar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.proyectofinal.R
import kotlin.random.Random

class Juego : Fragment() {
    lateinit var musicaFondo: MediaPlayer
    lateinit var respuestaUsuario: EditText
    lateinit var btnRespuesta: Button
    lateinit var b_Regresar:Button
    lateinit var sonidoRespuesta: MediaPlayer
    lateinit var sonidoRespuestaInc: MediaPlayer
    var numeroGenerado=0
    var numeroUsuario=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_juego, container, false)
        btnRespuesta = vista.findViewById(R.id.b_empezar)
        respuestaUsuario = vista.findViewById(R.id.respuesta)

        musicaFondo = MediaPlayer.create(activity, R.raw.parkle)
        sonidoRespuesta = MediaPlayer.create(activity, R.raw.correcto)
        sonidoRespuestaInc = MediaPlayer.create(activity, R.raw.incorrecto)
        reproducirMusica()
        generarNumero()

        b_Regresar = vista.findViewById(R.id.btnInicioA)
        b_Regresar.setOnClickListener {
            findNavController().navigate(R.id.action_juego_to_adivinaNunero)
        }

        btnRespuesta.setOnClickListener {
            val respuesta = respuestaUsuario.text.toString()
            if(respuesta.equals("")){
                Toast.makeText(activity,"Ingresa un valor", Toast.LENGTH_LONG).show()
                sonidoIncorrecto()
            }else{
                numeroUsuario = respuesta.toInt()
                if (numeroGenerado == numeroUsuario){
                    sonidoCorrecto()
                }else{
                    sonidoIncorrecto()
                    Toast.makeText(activity,"El valor era $numeroGenerado", Toast.LENGTH_SHORT).show()
                }
                generarNumero()
            }
        }
        return vista
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

    fun generarNumero(){
        numeroGenerado= Random.nextInt(1,10)
        respuestaUsuario.text.clear()
    }
}