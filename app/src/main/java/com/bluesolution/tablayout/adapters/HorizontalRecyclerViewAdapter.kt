package com.bluesolution.tablayout.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.squareup.picasso.Picasso

class HorizontalRecyclerViewAdapter (val list: ArrayList<String>) :
    RecyclerView.Adapter<HorizontalRecyclerViewAdapter.MyView>() {

    class MyView(view: View) : RecyclerView.ViewHolder(view){
        var imageView: ImageView
        init {
            imageView = view
                .findViewById<ImageView>(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item,
                parent,
                false
            )
        return MyView(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val listData = list[position]
        //Loading Image into view
        Picasso.get().load(listData).placeholder(R.mipmap.ic_launcher).into(holder.imageView)
    }
}