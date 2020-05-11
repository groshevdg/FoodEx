package groshevdg.foodex.ui.mainActivity.restorator.dishes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import groshevdg.foodex.model.Dish
import kotlinx.android.synthetic.main.item_restorator_dish.view.*

class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.irdName

    fun bind(dish: Dish, listener: DishClickListener) {
        name.text = dish.name
        itemView.setOnClickListener{ v -> listener.dishWasSelected(dish) }
    }
}