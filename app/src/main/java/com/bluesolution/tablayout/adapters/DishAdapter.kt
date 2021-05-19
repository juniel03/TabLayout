package com.bluesolution.tablayout.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluesolution.tablayout.R
import com.bluesolution.tablayout.data.Dish
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class DishAdapter( dishContx: Context?,
                   dishes: ArrayList<Dish>?,
                   listener: callback?): RecyclerView.Adapter<DishAdapter.distViewHolder>() {

    private var dishContx: Context? = dishContx
    private var dishes: ArrayList<Dish>? = dishes
    private var listener: callback? = listener

    interface callback {
        fun onDishClicked()
    }
    class distViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        //instanciate views
        var dishPic: ImageView
        var dish_name: TextView
        var dish_description: TextView
        init {
            //init views
            dishPic = itemView.findViewById(R.id.menu_item_image)
            dish_name = itemView.findViewById(R.id.menu_item_title)
            dish_description = itemView.findViewById(R.id.menu_item_description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): distViewHolder {
        val inflater = LayoutInflater.from(dishContx)
        val itemView: View = inflater.inflate(R.layout.menu_item, null, false)
        return distViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dishes!!.size
    }

    override fun onBindViewHolder(holder: distViewHolder, position: Int) {
        val dish: Dish = dishes!![position]

        holder.dish_name.setText(dish.itemTitle)
        holder.dish_description.setText(dish.itemDescription)

        val resources = dishContx!!.resources
        val resourceId =
            resources.getIdentifier(dish.itemImage, "drawable", dishContx!!.packageName)
        Glide.with(dishContx!!)
            .load(resourceId)
            .apply(RequestOptions().placeholder(R.drawable.food_background_1).fitCenter())
            .into(holder.dishPic)
    }
}