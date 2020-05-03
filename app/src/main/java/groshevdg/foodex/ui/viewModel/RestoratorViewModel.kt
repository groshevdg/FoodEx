package groshevdg.foodex.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Restorator
import groshevdg.foodex.ui.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RestoratorViewModel @Inject constructor(val database: AppDatabase) : ViewModel() {
    private val mutableRestorator: MutableLiveData<Restorator?> = MutableLiveData()
    val restorator: LiveData<Restorator?> = mutableRestorator

    fun tryLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            mutableRestorator.postValue(database.restoratorDao().getRetorator(email, password))
        }
    }

    fun registerRestorator(email: String, password: String, phone: String) {
        val restorator = Restorator()
        restorator.email = email
        restorator.password = password
        restorator.phone = phone

        viewModelScope.launch(Dispatchers.IO) { database.restoratorDao().insertRestorator(restorator) }
    }
}
