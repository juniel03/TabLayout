package com.bluesolution.tablayout.adapters.ui

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.CategoryAdapter
import com.bluesolution.tablayout.adapters.MenuPagesAdapter
import com.bluesolution.tablayout.data.CategoryData
import com.bluesolution.tablayout.data.Menu
import com.bluesolution.tablayout.data.RestaurantInfo
import com.bluesolution.tablayout.data.live.Data
import com.bluesolution.tablayout.data.live.LiveModel
import com.bluesolution.tablayout.databinding.ActivityRestaurantsBinding
import com.bluesolution.tablayout.util.TabLayout_Util
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList


class RestaurantsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantsBinding
    var liveDataList = ArrayList<LiveModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantsBinding.inflate(layoutInflater)
        val view = binding.root

        val data:List<Data>

        val livetitles = ArrayList<String>()
        var liveList = ArrayList<List<Data>>()

        setContentView(view)
        Log.d("tag", "restaurant activity")
        val jsonlive = this.assets.readFile("livemenu.json")
        val liveCategory = liveConvert(jsonlive)

        Log.d("tag", "live size ${liveCategory.data.size}")

        data = liveCategory.data
        Log.d("tag", "data $data")

        val top = data.groupBy{it.top}
        val keys = top.keys

        Log.d("tag", "keys $keys")

        for (key in keys){
            Log.d("tag", "item per $key ${top.get(key)}")
            val data = top.get(key)
            liveList.add(data!!)
            liveDataList.add(LiveModel(data))
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(key))
            livetitles.add(key)
        }

        binding.viewPagerMenu.isUserInputEnabled = false
        binding.viewPagerMenu.adapter = MenuPagesAdapter(liveDataList, supportFragmentManager, lifecycle)

        binding.tabLayout.setupWithViewPager(binding.viewPagerMenu, livetitles)

        for (i in 0 until binding.tabLayout.getTabCount()) {
            val tab = (binding.tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(TabLayout_Util.dpToPx(8), 0, TabLayout_Util.dpToPx(8), 0)
            tab.requestLayout()
        }

    }
        fun TabLayout.setupWithViewPager(viewPager: ViewPager2, labels: ArrayList<String>) {
        Log.d("tag", "labels size ${labels.size} number of items ${viewPager.adapter?.itemCount}")
        if (labels.size != viewPager.adapter?.itemCount)
            throw Exception("The size of list and the tab count should be equal!")

        TabLayoutMediator(this, viewPager,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    tab.text = labels[position]
                }).attach()
    }

    fun AssetManager.readFile(fileName: String) = open(fileName)
            .bufferedReader()
            .use { it.readText()
            }

    fun jsonConvert(jsonString: String) : CategoryData {
        return Gson().fromJson(jsonString, CategoryData::class.java)
    }
    fun liveConvert(jsonString: String) : LiveModel {
        return Gson().fromJson(jsonString, LiveModel::class.java)
    }
}