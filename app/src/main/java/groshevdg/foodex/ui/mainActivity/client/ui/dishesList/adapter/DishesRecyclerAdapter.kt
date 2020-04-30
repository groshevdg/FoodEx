package groshevdg.foodex.ui.mainActivity.client.ui.dishesList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish

class DishesRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val list: MutableList<Dish> = ArrayList()

    fun setData(list: List<Dish>) {
        this.list.addAll(list)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dishes, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(list[position])
    }
}