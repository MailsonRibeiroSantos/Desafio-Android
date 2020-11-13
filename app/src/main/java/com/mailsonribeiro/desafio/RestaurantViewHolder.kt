package com.mailsonribeiro.desafio

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RestaurantViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    private val ivImage: ImageView = view.findViewById(R.id.ivImage)
    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvAdress: TextView = view.findViewById(R.id.tvAddress)
    private val tvHour: TextView = view.findViewById(R.id.tvHour)


    fun bind(restaurant: Restaurant) {
        tvName.text = restaurant.name
        tvAdress.text = """${restaurant.address.street}, ${restaurant.address.number} - ${restaurant.address.neighborhood},""".trimMargin() +
                if(restaurant.address.city==null) "" else restaurant.address.city

        tvHour.text = "Fecha às " + restaurant.hour

        val avatarDrawable = ContextCompat.getDrawable(view.context, restaurant.image);

        ivImage.setImageDrawable(avatarDrawable)

    }


}