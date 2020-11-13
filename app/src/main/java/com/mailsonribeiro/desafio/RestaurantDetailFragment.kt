package com.mailsonribeiro.desafio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class RestaurantDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage(view)
        navigateRecipDeatail(view)
    }

    fun loadImage(view:View){
        val idImage = arguments?.getInt(HomeFragment.KEY_IMAGE)
        if (idImage !=null){
            val avatarDrawable = ContextCompat.getDrawable(view.context, idImage);

            view.findViewById<ImageView>(R.id.ivImageRestaurant)
                .setImageDrawable(avatarDrawable)
        }
    }

    fun navigateRecipDeatail(view:View){
        val navController = Navigation.findNavController(view)

        val menu = Menu("Salada com molho Gengibre","Sed ut perspiciatis, unde " +
                "omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem " +
                "aperiam eaque ipsa, quae ab illo inventore veritatis.",R.drawable.aoyama)
        val menus = arrayListOf<Menu>(menu,menu,menu,menu,menu,menu,menu,menu,menu,menu
        )

        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_restaurant)

        val viewAdapter = RestaurantDetailAdapter(menus)

        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }



}