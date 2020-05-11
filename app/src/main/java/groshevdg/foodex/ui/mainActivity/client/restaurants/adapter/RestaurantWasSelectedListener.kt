package groshevdg.foodex.ui.mainActivity.client.restaurants.adapter

import groshevdg.foodex.model.Restaurant

interface RestaurantWasSelectedListener {
    fun selected(restaurant: Restaurant)
}