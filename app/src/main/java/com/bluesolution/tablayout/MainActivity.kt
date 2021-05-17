package com.bluesolution.tablayout

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bluesolution.tablayout.adapters.ViewPager2Adapter
import com.bluesolution.tablayout.databinding.ActivityMainBinding
import com.bluesolution.tablayout.fragments.Fragment1
import com.bluesolution.tablayout.fragments.Fragment2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setUpTabs()
    }

    private fun setUpTabs() {
        val fragments: ArrayList<Fragment> = arrayListOf(
                Fragment1(),
                Fragment2()
        )
        val adapter = ViewPager2Adapter(fragments, this)
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = adapter

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("1"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("2"));



        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.setCurrentItem(tab.position)
                Log.d("tag", "position ${tab.position}")

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

//        binding.tabLayout.setupWithViewPager(binding.viewPager, listOf("Tab A", "Tab B"))
    }
//    fun TabLayout.setupWithViewPager(viewPager: ViewPager2, labels: List<String>) {
//
//        if (labels.size != viewPager.adapter?.itemCount)
//            throw Exception("The size of list and the tab count should be equal!")
//
//        TabLayoutMediator(this, viewPager,
//                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
//                    tab.text = labels[position]
//                }).attach()
//    }

}