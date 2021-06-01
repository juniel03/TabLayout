package com.bluesolution.tablayout.adapters.nested

import DividerItemDecorator
import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.MenuItemsAdapter
import com.bluesolution.tablayout.data.live.LiveModel
import kotlinx.android.synthetic.main.category_layout.view.*

class CategorAdapter(private val category: ArrayList<LiveModel>, private val listener: Items.OnItemClickListener) : RecyclerView.Adapter<CategorAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rv_child
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategorAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return category.size
    }


    override fun onBindViewHolder(holder: CategorAdapter.ViewHolder, position: Int) {
        val parent = category[position]
        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = Items(parent.data, listener)
            setRecycledViewPool(viewPool)
        }
        val dividerItemDecoration: RecyclerView.ItemDecoration = DividerItemDecorator(let {
            ContextCompat.getDrawable(holder.recyclerView.context, R.drawable.divider)
        }!!)
        holder.recyclerView.addItemDecoration(dividerItemDecoration)
    }
}