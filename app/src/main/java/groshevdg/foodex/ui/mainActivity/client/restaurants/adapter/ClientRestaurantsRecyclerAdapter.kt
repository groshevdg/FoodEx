package groshevdg.foodex.ui.mainActivity.client.restaurants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.R
import groshevdg.foodex.model.Restaurant

class ClientRestaurantsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val restaurants: MutableList<Restaurant> = ArrayList()

    fun setData(list: List<Restaurant>) {
        restaurants.clear()
        restaurants.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ClientRestaurantViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_client_restaurant_list, parent, false))
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ClientRestaurantViewHolder).bind(restaurants[position])
    }
}