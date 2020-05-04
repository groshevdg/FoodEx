package groshevdg.foodex.ui.mainActivity.restorator.restourants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class RestaurantsViewModel @Inject constructor(private val database: AppDatabase) : ViewModel() {
    private val mutableRestaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = mutableRestaurants

    fun getRestaurants(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            database.restaurantDao().getRestaurants(id).collect { list -> mutableRestaurants.postValue(list) }
        }
    }

    fun saveRestaurantIntoBD(restaurant: Restaurant) {
        viewModelScope.launch(Dispatchers.IO) { database.restaurantDao().insertRestaurant(restaurant) }
    }
}
