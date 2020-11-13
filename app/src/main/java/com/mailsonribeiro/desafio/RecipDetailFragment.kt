package com.mailsonribeiro.desafio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat


class RecipDetailFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recip_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData(view)
    }

    fun loadData(view:View){
        val idImage = arguments?.getInt(RestaurantDetailFragment.KEY_IMAGE)
        if (idImage !=null){
            val avatarDrawable = ContextCompat.getDrawable(view.context, idImage);

            view.findViewById<ImageView>(R.id.ivRecipDetail)
                .setImageDrawable(avatarDrawable)
        }

        val descricao = arguments?.getString(RestaurantDetailFragment.KEY_DESCRIPTION)

        if (descricao !=null){
            view.findViewById<TextView>(R.id.tvRecipDetail).text = descricao
        }
    }
}