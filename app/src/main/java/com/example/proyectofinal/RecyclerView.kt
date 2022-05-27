package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectofinal.rickandmorty.AdaptadorPersonaje
import com.example.proyectofinal.rickandmorty.Personaje

//rickandmorty

class RecyclerView : AppCompatActivity() {
    lateinit var miRecyclerView: RecyclerView
    val listPersonajes = ArrayList<Personaje>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        miRecyclerView = findViewById(R.id.RecyclerPersonajes)
        miRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getPersonaje()
    }

    fun getPersonaje(){
        val queue = Volley.newRequestQueue(this)
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