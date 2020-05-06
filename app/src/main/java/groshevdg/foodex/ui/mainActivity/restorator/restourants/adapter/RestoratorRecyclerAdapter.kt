package groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.R
import groshevdg.foodex.model.Restaurant

class RestoratorRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val restaurants: MutableList<Restaurant> = ArrayList()
    private lateinit var listener: SelectedRestaurantListener

    fun addListener(listener: SelectedRestaurantListener) {
        this.listener = listener
    }

    fun setData(data: List<Restaurant>) {
        restaurants.clear()
        restaurants.addAll(data)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RestaurantViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false))
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as RestaurantViewHolder).bind(restaurants[position], listener)
    }
}