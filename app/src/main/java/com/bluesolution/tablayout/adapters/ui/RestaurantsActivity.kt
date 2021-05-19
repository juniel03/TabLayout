package com.bluesolution.tablayout.adapters.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.CategoryAdapter
import com.bluesolution.tablayout.data.RestaurantInfo
import com.bluesolution.tablayout.databinding.ActivityRestaurantsBinding
import java.util.*


class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantsBinding
    private lateinit var restauranList: ArrayList<RestaurantInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadData()
    }

    private fun loadData() {
        getAllRestaurants()
        binding.viewPager.adapter = CategoryAdapter(restauranList, supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

    }
    private fun getAllRestaurants() {
        //get restaurants
        restauranList = ArrayList<RestaurantInfo>()
        val iconarray =
            this.resources.getStringArray(R.array.restaurant_icons)
        val namearray =
            this.resources.getStringArray(R.array.restaurant_names1)
        val discriptionarray =
            this.resources.getStringArray(R.array.restaurant_descriptions)
        for (i in namearray.indices) {
            val name = namearray[i]
            val description = discriptionarray[i]
            val logo = iconarray[i]
            val restaurant = RestaurantInfo(name, description, logo)
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(namearray[i]));
            restauranList.add(restaurant)
        }
    }
}