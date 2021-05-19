package com.bluesolution.tablayout.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bluesolution.tablayout.data.RestaurantInfo
import com.bluesolution.tablayout.fragments.Items
import java.util.*

class CategoryAdapter(val restauranList: ArrayList<RestaurantInfo>, fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        Log.d("tag", "restaurant list adapter: $restauranList.res")
        val resto = Items()
        resto.setRestaurant(restauranList.get(position))
        return resto
    }

    override fun getCount(): Int {
        return restauranList.size
    }
}