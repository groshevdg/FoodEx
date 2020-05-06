package groshevdg.foodex.ui.mainActivity.restorator.restourants.dialog

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import groshevdg.foodex.R
import groshevdg.foodex.model.Restaurant

class RegisterNewRestaurantDialog(val listener: OnDialogButtonClickListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = activity?.layoutInflater?.inflate(R.layout.dialog_create_new_restaurant, null)
        return AlertDialog.Builder(requireContext())
                .setMessage("Сведения о заведении")
                .setView(view)
                .setPositiveButton("Создать") { dialog, which ->

                    val name = view?.findViewById<EditText>(R.id.dcnrName)?.text.toString()
                    val address = view?.findViewById<EditText>(R.id.dcnrAddress)?.text.toString()
                    val phone = view?.findViewById<EditText>(R.id.dcnrPhone)?.text.toString()
                    val photo = view?.findViewById<EditText>(R.id.dcnrPhoto)?.text.toString()
                    val type = view?.findViewById<Spinner>(R.id.dcnrType)?.selectedItem.toString()

                    val restaurant = Restaurant()
                    restaurant.name = name
                    restaurant.address = address
                    restaurant.phone = phone
                    restaurant.photo = photo
                    restaurant.type = type

                    listener.onCreateButtonWasClicked(restaurant)}

            .setNegativeButton("Отмена", { dialog, which ->  })
            .create()
    }
}