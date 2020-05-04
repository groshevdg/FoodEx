package groshevdg.foodex.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Restaurant(var name: String, var address: String,
                 var type: String, var photo: String, var phone: String, var restoratorId: Long,
                 var rating: Long) : Serializable {
    @PrimaryKey(autoGenerate = true) var id: Int? = null

    constructor() : this("", "", "", "", "", 0, 0)
}