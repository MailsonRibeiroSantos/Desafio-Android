package com.mailsonribeiro.desafio

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RestaurantDetailViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    private val ivImage: ImageView = view.findViewById(R.id.ivImageRestaurantDetail)
    private val tvName: TextView = view.findViewById(R.id.tvNameRestaurantDetail)

    fun bind(menu: Menu) {
        tvName.text = menu.name
        val avatarDrawable = ContextCompat.getDrawable(view.context, menu.image);

        ivImage.setImageDrawable(avatarDrawable)
    }
}