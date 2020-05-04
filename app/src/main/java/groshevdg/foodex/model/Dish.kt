package groshevdg.foodex.model

import androidx.room.Entity

@Entity //Need primary key
data class Dish(val name: String, val image: String, val price: String, val weight: String)