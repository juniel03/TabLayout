package com.bluesolution.tablayout.adapters.nested

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.adapters.MenuItemsAdapter
import com.bluesolution.tablayout.data.live.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.menu_item.view.*

class Items(private val items: List<Data>, private val listener: Items.OnItemClickListener) : RecyclerView.Adapter<Items.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val title : TextView
        val price : TextView
        val desc : TextView
        val imageView: ImageView
        init {
            title = itemView
                    .findViewById<TextView>(R.id.menu_item_title)
            price = itemView
                    .findViewById<TextView>(R.id.menu_item_price)
            desc = itemView
                    .findViewById<TextView>(R.id.menu_item_description)
            imageView = itemView
                    .findViewById<ImageView>(R.id.menu_item_image)
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val item = items[position]
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position, item)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int ,item: Data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.name
        holder.desc.text =item.ex
        holder.price.text =item.orignPrice
        Picasso.get().load(item.img[0]).placeholder(R.mipmap.ic_launcher).into(holder.imageView)
    }

}