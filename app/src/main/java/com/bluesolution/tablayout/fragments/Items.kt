package com.bluesolution.tablayout.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.DishAdapter
import com.bluesolution.tablayout.data.Dish
import com.bluesolution.tablayout.data.RestaurantInfo
import com.bluesolution.tablayout.databinding.FragmentItemsBinding
import java.util.*

class Items : Fragment() {
    private lateinit var _binding: FragmentItemsBinding
    private val binding get() = _binding
    private lateinit var resto: RestaurantInfo

    fun setRestaurant(restaurant: RestaurantInfo) {
       this.resto = restaurant
        Log.d("Tag", "items called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        Log.d("tag", "item onCreate View called")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("tag", "item onViewCreated called")

        resto.dishes = getAllDishes()
        _binding.recycler.hasFixedSize()
        _binding.recycler.layoutManager = LinearLayoutManager(activity)

        val callback: DishAdapter.callback = object : DishAdapter.callback {
            override fun onDishClicked() {
                //add selected dish to user menu
            }
        }
        Log.d("tag", "restodishes ${resto.dishes}")
        _binding.recycler.adapter = DishAdapter(activity, resto.dishes, callback)
    }
    private fun getAllDishes(): ArrayList<Dish>? {

        //get dishes first
        val dishes: ArrayList<Dish> = ArrayList<Dish>()
        val dishNames =
            this.resources.getStringArray(R.array.dishes)
        val dishPics =
            this.resources.getStringArray(R.array.dish_icons)
        val dishDescription =
            this.resources.getStringArray(R.array.dish_descriptions)
        for (i in dishNames.indices) {
            val dish_name = dishNames[i]
            val dish_description = dishDescription[i]
            val dish_icon = dishPics[i]
            val dish = Dish(dish_name, dish_description, dish_icon)
            dishes.add(dish)
        }
        return dishes
    }
}