package com.bluesolution.tablayout.adapters

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bluesolution.tablayout.data.Menu
import com.bluesolution.tablayout.data.live.Data
import com.bluesolution.tablayout.data.live.LiveModel
import com.bluesolution.tablayout.fragments.MenuItemsFragment

class MenuPagesAdapter(var livelist: ArrayList<LiveModel>, fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = livelist.size

    override fun createFragment(position: Int): Fragment = MenuItemsFragment().apply {
        arguments = bundleOf(
            "livedata" to livelist[position]
        )
    }
}