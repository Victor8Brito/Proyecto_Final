package com.example.proyectofinal.retrofit

import com.google.gson.annotations.SerializedName

data class DogResponse (@SerializedName("status") var status:String,@SerializedName("message") var image:List<String>)