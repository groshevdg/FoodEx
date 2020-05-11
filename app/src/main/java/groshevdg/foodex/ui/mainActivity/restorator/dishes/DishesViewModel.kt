package groshevdg.foodex.ui.mainActivity.restorator.dishes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Dish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class DishesViewModel @Inject constructor(private val database: AppDatabase) : ViewModel() {

    private val mutableDishes: MutableLiveData<List<Dish>> = MutableLiveData()
    val dishes: LiveData<List<Dish>> = mutableDishes

    fun getDishes(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            database.dishDao().getDish(id).collect { list -> mutableDishes.postValue(list) }

        }
    }

    fun saveDishInBD(dish: Dish) {
        viewModelScope.launch(Dispatchers.IO) {
            database.dishDao().insertDish(dish)
        }
    }

    fun updateDish(dish: Dish) {
        viewModelScope.launch(Dispatchers.IO) { database.dishDao().insertDish(dish) }
    }

    fun deleteDish(dish: Dish) {
        viewModelScope.launch(Dispatchers.IO) { database.dishDao().deleteDish(dish) }
    }
}
