package com.example.proyectofinal.retrofit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.proyectofinal.databinding.ItemDogBinding


class DogViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemDogBinding.bind(view)

    fun bine(image:String){
        Picasso.get().load(image).into(binding.IVdog)
    }
}