package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal.rickandmorty.AdaptadorPersonaje
import com.example.proyectofinal.rickandmorty.Personaje

//rickandmorty

class RecyclerView : Fragment() {
    lateinit var miRecyclerView: RecyclerView
    lateinit var botonRegresar: Button
    val listPersonajes = ArrayList<Personaje>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_recycler_view, container, false)
        miRecyclerView = vista.findViewById(R.id.RecyclerPersonajes)
        miRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        getPersonaje()
        botonRegresar =vista.findViewById(R.id.btnHome4)
        botonRegresar.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerView_to_pantalla_principal)
        }
        return vista
    }

    fun getPersonaje(){
        val queue = Volley.newRequestQueue(activity)
        val url = "https://rickandmortyapi.com/api/character"
        val jsonObject = JsonObjectRequest(Request.Method.GET,url,null,
            {respuesta->
                val newjson =respuesta.getJSONArray("results")
                for (i in 0..newjson.length()-1) {
                    val newobj = newjson.getJSONObject(i)
                    val personaje = Personaje(newobj.getString("name"),
                        newobj.getString("image"))
                    listPersonajes.add(personaje)
                }
                miRecyclerView.adapter = AdaptadorPersonaje(listPersonajes)
            },{ error->
                Log.e("Exam","Error")
            }
        )
        queue.add(jsonObject)
    }
}