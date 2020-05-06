package groshevdg.foodex.ui.mainActivity.client.dishesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Restaurant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClientDishesViewModel @Inject constructor(val database: AppDatabase) : ViewModel() {
    private val mutableRestaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = mutableRestaurants

    private val mutableDishes = MutableLiveData<List<Dish>>()
    val dishes: LiveData<List<Dish>> = mutableDishes

    fun getAllDishes() {
        viewModelScope.launch(Dispatchers.IO) {
            database.dishDao().getAllDishes().collect { list ->  mutableDishes.postValue(list)}
        }
    }

    fun getAllRestaurants() {
        viewModelScope.launch(Dispatchers.IO) {
            database.restaurantDao().getAllRestaurants().collect {
                mutableRestaurants.postValue(it)
            }
        }
    }
}