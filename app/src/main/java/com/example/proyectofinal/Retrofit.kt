package com.example.proyectofinal

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectofinal.retrofit.APIService
import com.example.proyectofinal.retrofit.DogAdapter
import com.example.proyectofinal.retrofit.DogResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.recyclerview.widget.RecyclerView

class Retrofit : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var adapter: DogAdapter
    private val dogImage = mutableListOf<String>()
    private lateinit var search:SearchView
    private lateinit var recycler:RecyclerView
    private lateinit var vRoot: ConstraintLayout
    lateinit var BOTON:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.activity_retrofit, container, false)
        search = vista.findViewById(R.id.SearchDog)
        search.setOnQueryTextListener(this)
        vRoot = vista.findViewById(R.id.viewRoot)
        recycler = vista.findViewById(R.id.rvDog)
        BOTON = vista.findViewById(R.id.btnhome3)
        BOTON.setOnClickListener {
            findNavController().navigate(R.id.action_retrofit_to_pantalla_principal)
        }

        initRecyclerView()
        return vista
    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImage)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.adapter = adapter

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call:Response<DogResponse> = getRetrofit().create(APIService::class.java).getDogsBYBreeds("$query/images")
            val puppies:DogResponse? = call.body()
            activity?.runOnUiThread{
                if(call.isSuccessful){
                    val images = puppies?.image ?: emptyList()
                    dogImage.clear()
                    dogImage.addAll(images)
                    adapter.notifyDataSetChanged()
                }else{
                    showError()
                }
                hideKEyBoard()
            }
        }
    }

    private fun hideKEyBoard() {
        val imm:InputMethodManager = activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(vRoot.windowToken,0)
    }

    private fun showError(){
        Toast.makeText(activity, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}