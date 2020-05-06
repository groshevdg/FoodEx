package groshevdg.foodex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Dish(var name: String, var description: String, var image: String,
                var price: String, var weight: String, var restaurantId: Int) {

    @PrimaryKey(autoGenerate = true) var id: Int? = null

    constructor(name: String, description: String, image: String, weight: String, price: String)
            : this(name, description, image, price, weight, restaurantId = -1)
}