package com.mailsonribeiro.desafio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val address = Address("Av. Lavandisca", 717, "Indianópolis", "São Paulo")
        val address1 = Address("Alameda dos Arapanés", 532 , "Moema",null)
        val address2 = Address("Av. Moaci", 187, "Moema", "São Paulo")
        val address3 = Address("Alameda Jauaperi", 626,"Moema",null)

        val restaurants = arrayListOf<Restaurant>(Restaurant("Tony Roma's",address,"00:00",R.drawable.tony),
            Restaurant("Aoyama - Moema",address1,"00:00",R.drawable.aoyama),
            Restaurant("Outback - Moema",address2,"00:00",R.drawable.outback),
            Restaurant("Sí Señor!",address3,"01:00",R.drawable.si)
        )

       val navController = Navigation.findNavController(view)

        val viewManager = LinearLayoutManager(view.context)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val viewAdapter = RestaurantAdapter(restaurants){
            val bundle = bundleOf(KEY_IMAGE to it.image)
            navController.navigate(R.id.restaurantDetailFragment,bundle)
        }
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    companion object {
        const val KEY_IMAGE = "IMAGE"
    }

}