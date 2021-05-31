package com.bluesolution.tablayout.fragments

import DividerItemDecorator
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.MenuItemsAdapter
import com.bluesolution.tablayout.data.Item
import com.bluesolution.tablayout.data.Menu
import com.bluesolution.tablayout.data.live.Data
import com.bluesolution.tablayout.data.live.LiveModel


class MenuItemsFragment : Fragment(), MenuItemsAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val data: LiveModel

        arguments?.let {bundle ->
            val rec = view.findViewById<RecyclerView>(R.id.itemsRecyclerview)
            rec.layoutManager = LinearLayoutManager(activity)
            data = bundle.getParcelable("livedata")!!
            Log.d("tag", "fragment live data $data")
            rec.adapter = MenuItemsAdapter(dataItem = data.data,listener =  this)
            val dividerItemDecoration: RecyclerView.ItemDecoration = DividerItemDecorator(activity?.let {
                ContextCompat.getDrawable(
                    it, R.drawable.divider)
            }!!)
            rec.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onItemClick(position: Int, item: Data) {
        Toast.makeText(activity, "position $position , Item Title = ${item.name}, Item description = ${item.status}, Item Image = ${item.img[0]}", Toast.LENGTH_SHORT).show()
    }

}