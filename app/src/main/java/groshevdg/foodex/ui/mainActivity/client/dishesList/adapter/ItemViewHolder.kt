package groshevdg.foodex.ui.mainActivity.client.dishesList.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import kotlinx.android.synthetic.main.item_dishes.view.*

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name = itemView.idNameTextView
    val image = itemView.idImage
    val price = itemView.idPrice
    val weight = itemView.idWeight

    fun bind(dish: Dish, listener: DishWasSelected) {
        itemView.setOnClickListener{ v -> listener.selected(dish)}
        name.text = dish.name
        image.loadImage(image.context, dish.image)
        price.text = dish.price
        weight.text = dish.weight
    }
}

fun ImageView.loadImage(context: Context, url: String) {
    Glide.with(context).load(url).placeholder(R.drawable.placeholder).into(this)
}