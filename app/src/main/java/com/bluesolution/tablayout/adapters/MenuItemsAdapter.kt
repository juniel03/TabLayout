package com.bluesolution.tablayout.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.data.Item
import com.bluesolution.tablayout.data.live.Data
import com.squareup.picasso.Picasso

class MenuItemsAdapter (private val dataItem: List<Data>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<MenuItemsAdapter.MyView>() {

    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var textviewTitle: TextView
        var textViewDesc: TextView
        var imageLogo: ImageView
        init {
            textviewTitle = view
                .findViewById<TextView>(R.id.menu_item_title)
            textViewDesc = view
                .findViewById<TextView>(R.id.menu_item_description)
            imageLogo = view
                .findViewById<ImageView>(R.id.menu_item_image)
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val item = dataItem[position]
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position, item)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int ,item: Data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.menu_item,
                parent,
                false
            )
        return MyView(itemView)
    }

    override fun getItemCount(): Int {
        return dataItem.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        Log.d("tag", "recyclerview data = $dataItem")
        holder.textviewTitle.text = dataItem[position].name
        holder.textViewDesc.text = dataItem[position].status
        Picasso.get().load(dataItem[position].img[0]).placeholder(R.mipmap.ic_launcher).into(holder.imageLogo)
    }
}