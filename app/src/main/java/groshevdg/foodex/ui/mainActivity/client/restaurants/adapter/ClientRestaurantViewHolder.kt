package groshevdg.foodex.ui.mainActivity.client.restaurants.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.loadImage
import kotlinx.android.synthetic.main.item_client_restaurant_list.view.*

class ClientRestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.icrlName
    val address = itemView.icrlAddress
    val rating = itemView.icrlRating
    val photo = itemView.icrlPhoto

    fun bind(restaurant: Restaurant) {
        name.text = (restaurant.type + " " + restaurant.name)
        address.text = restaurant.address
        rating.text = restaurant.rating.toString()
        photo.loadImage(photo.context, restaurant.photo, photo)
    }
}