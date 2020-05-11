package groshevdg.foodex.ui.mainActivity.client.detalize

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

class RestaurantDetalizeViewModel @Inject constructor(val database: AppDatabase) : ViewModel() {
    private val mutableDishes: MutableLiveData<List<Dish>> = MutableLiveData()
    val dishes: LiveData<List<Dish>> = mutableDishes

    fun getDishes(restaurant: Restaurant) {
        viewModelScope.launch(Dispatchers.IO) {
            database.dishDao().getDish(restaurant.id!!).collect {
                mutableDishes.postValue(it)
            }
        }
    }
}