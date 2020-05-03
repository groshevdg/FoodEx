package groshevdg.foodex.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClientViewModel @Inject constructor(val database: AppDatabase) : ViewModel() {
    private val mutableClient = MutableLiveData<Client?>()
    val client: LiveData<Client?> = mutableClient


    fun tryLogin(email: String, password: String) {
       viewModelScope.launch(Dispatchers.IO) {
           mutableClient.postValue(database.clientDao().getClient(email, password))
       }
    }

    fun registerClient(email: String, password: String, phone: String) : Client {
        val client = Client()
        client.email = email
        client.password = password
        client.phone = phone

        viewModelScope.launch(Dispatchers.IO) { database.clientDao().insertClient(client) }
        return client
    }
}
