package com.mailsonribeiro.desafio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestaurantDetailAdapter(private val menus: List<Menu>) : RecyclerView.Adapter<RestaurantDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)

        return RestaurantDetailViewHolder(view)
    }

    override fun getItemCount() = menus.size

    override fun onBindViewHolder(holder: RestaurantDetailViewHolder, position: Int) {
        holder.bind(menus[position])
    }
}