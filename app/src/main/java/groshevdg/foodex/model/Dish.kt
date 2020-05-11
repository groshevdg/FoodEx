package groshevdg.foodex.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Dish(var name: String, var description: String, var image: String,
                var price: String, var weight: String, var restaurantId: Int) : Serializable {

    @PrimaryKey(autoGenerate = true) var id: Int? = null

    constructor(name: String, description: String, image: String, weight: String, price: String)
            : this(name, description, image, price, weight, restaurantId = -1)
}