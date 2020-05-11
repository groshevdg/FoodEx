package groshevdg.foodex.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Favourite(@Embedded val dish: Dish) {
    @PrimaryKey(autoGenerate = true)
    var favouriteId = -1
}