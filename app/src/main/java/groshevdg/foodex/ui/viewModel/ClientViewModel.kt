package groshevdg.foodex.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import groshevdg.foodex.data.db.database.AppDatabase
import groshevdg.foodex.model.Client
import groshevdg.foodex.ui.Navigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClientViewModel @Inject constructor(val database: AppDatabase) : ViewModel() {
    fun tryLogin(email: String, password: String) : Client? {
        var client = Client()
        viewModelScope.launch(Dispatchers.IO) { client = database.clientDao().getClient(email, password) }
        return client
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
