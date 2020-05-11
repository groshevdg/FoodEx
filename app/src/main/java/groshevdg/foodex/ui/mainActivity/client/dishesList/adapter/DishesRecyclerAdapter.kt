package groshevdg.foodex.ui.mainActivity.client.dishesList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish

class DishesRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var listener: DishWasSelected
    val dishes: MutableList<Dish> = ArrayList()

    fun setDishListener(l: DishWasSelected) {
        this.listener = l
    }

    fun setData(list: List<Dish>) {
        dishes.clear()
        dishes.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dishes, parent, false))
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(dishes[position], listener)
    }
}