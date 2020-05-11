package groshevdg.foodex.ui.mainActivity.client.dishesList.adapter

import groshevdg.foodex.model.Dish

interface DishWasSelected {
    fun selected(dish: Dish)
}