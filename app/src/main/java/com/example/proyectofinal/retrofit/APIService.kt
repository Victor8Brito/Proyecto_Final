package com.example.proyectofinal.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getDogsBYBreeds(@Url url:String):Response<DogResponse>
}