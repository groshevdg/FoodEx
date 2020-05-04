package groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter

import groshevdg.foodex.model.Restaurant

interface SelectedRestaurantListener {
    fun onRestaurantClick(restaurant: Restaurant)
}