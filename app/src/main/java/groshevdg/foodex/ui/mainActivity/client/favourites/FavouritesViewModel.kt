package groshevdg.foodex.ui.mainActivity.client.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Favourite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritesViewModel @Inject constructor(private val database: AppDatabase) : ViewModel() {
    private val mutableFavourites: MutableLiveData<List<Favourite>> = MutableLiveData()
    val favourites: LiveData<List<Favourite>> = mutableFavourites

    private val mutableSaved: MutableLiveData<Boolean> = MutableLiveData()
    val saved: LiveData<Boolean> = mutableSaved

    fun getMyFavourites() {
        viewModelScope.launch(Dispatchers.IO) {
            database.favouritesDao().getFavourites().collect {
                mutableFavourites.postValue(it)
            }
        }
    }

    fun addFavourite(favourite: Favourite) {
        viewModelScope.launch(Dispatchers.IO) {
            database.favouritesDao().addFavouriteDish(favourite)
        }
    }

    fun checkDishHasAdded(dish: Dish) {
        viewModelScope.launch(Dispatchers.IO) {
            mutableSaved.postValue(database.favouritesDao().checkAlreadySaved(dish.id!!))
        }
    }

    fun removeFromFavourites(dish: Dish) {
        viewModelScope.launch(Dispatchers.IO) {
            database.favouritesDao().deleteFromFavourites(dish.id!!)
        }
    }
}