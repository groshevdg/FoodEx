package groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.model.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.irName

    fun bind(restaurant: Restaurant, listener: SelectedRestaurantListener) {
        name.text = restaurant.name
        itemView.setOnClickListener { v -> listener.onRestaurantClick(restaurant) }
    }
}