package com.bluesolution.tablayout.data

import java.util.*

data class RestaurantInfo (
     var restaurantName: String? = null,
     var description: String? = null,
     var logoName: String? = null,
     var dishes: ArrayList<Dish>? = null
)
