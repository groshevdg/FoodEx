package groshevdg.foodex.ui.mainActivity.restorator.dishes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish

class DishesRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val dishes: MutableList<Dish> = ArrayList()

    fun setData(list: List<Dish>) {
        dishes.clear()
        dishes.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DishViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restorator_dish, parent, false))
    }

    override fun getItemCount(): Int {
       return dishes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DishViewHolder).bind(dishes[position])
    }
}