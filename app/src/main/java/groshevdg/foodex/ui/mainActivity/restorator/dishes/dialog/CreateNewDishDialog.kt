package groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import kotlinx.android.synthetic.main.dialog_create_new_dish.view.*

class CreateNewDishDialog(val listener: OnDialogButtonClickListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity?.layoutInflater?.inflate(R.layout.dialog_create_new_dish, null)
        return AlertDialog.Builder(requireContext())
            .setMessage("Описание нового блюда")
            .setView(view)
            .setPositiveButton("Создать") { dialog, which ->
                val name = view?.dcndName?.text.toString()
                val description = view?.dcndDescription?.text.toString()
                val photo = view?.dcndPhoto?.text.toString()
                val weight = view?.dcndWeight?.text.toString()
                val price = view?.dcndPrice?.text.toString()

                val dish = Dish(name, description, photo, weight, price)

                listener.buttonIsClicked(dish)
            }
            .setNegativeButton("Отмена", {dialog, which ->  })
            .create()
    }
}