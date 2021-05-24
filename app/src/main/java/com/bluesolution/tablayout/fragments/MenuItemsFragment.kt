package com.bluesolution.tablayout.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.MenuItemsAdapter
import com.bluesolution.tablayout.data.Item
import com.bluesolution.tablayout.data.Menu


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
        val menu: Menu
        arguments?.let {bundle ->
            val rec = view.findViewById<RecyclerView>(R.id.itemsRecyclerview)
            rec.layoutManager = LinearLayoutManager(activity)
            menu = bundle.getParcelable("menu")!!
            val menuItem: List<Item> = menu.items
            rec.adapter = MenuItemsAdapter(menuItem = menuItem,listener =  this)
        }
    }

    override fun onItemClick(position: Int, item: Item) {
        Toast.makeText(activity, "position $position , Item Title = ${item.title}, Item description = ${item.description}, Item Image = ${item.image}", Toast.LENGTH_SHORT).show()
    }

}