package groshevdg.foodex.ui.mainActivity.restorator.dishes.adapter

import groshevdg.foodex.model.Dish

interface DishClickListener {
    fun dishWasSelected(dish: Dish)
}