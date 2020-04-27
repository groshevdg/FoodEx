package groshevdg.foodex.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Client {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
    var name: String = ""
    var surname: String = ""
    var phone: String = ""
    var email: String = ""
    var password: String = ""
    var address: String = ""
}