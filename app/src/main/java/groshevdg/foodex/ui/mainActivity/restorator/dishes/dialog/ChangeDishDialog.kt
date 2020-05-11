package groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import kotlinx.android.synthetic.main.dialog_create_new_dish.view.*


class ChangeDishDialog(val listener: OnDialogButtonClickListener, val dish: Dish) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = activity?.layoutInflater?.inflate(R.layout.dialog_create_new_dish, null)
        view?.dcndName?.setText(dish.name)
        view?.dcndDescription?.setText(dish.description)
        view?.dcndPhoto?.setText(dish.image)
        view?.dcndWeight?.setText(dish.weight)
        view?.dcndPrice?.setText(dish.price)

        return AlertDialog.Builder(requireContext())
            .setMessage("Редактирование блюда")
            .setView(view)
            .setPositiveButton("Изменить") { dialog, which ->
                val name = view?.dcndName?.text.toString()
                val description = view?.dcndDescription?.text.toString()
                val photo = view?.dcndPhoto?.text.toString()
                val weight = view?.dcndWeight?.text.toString()
                val price = view?.dcndPrice?.text.toString()

                dish.name = name
                dish.description = description
                dish.price = price
                dish.weight = weight
                dish.image = photo

                listener.refactorDish(dish)
            }
            .setNegativeButton("Отмена", {dialog, which ->  })
            .setNeutralButton("Удалить", {dialog, which -> listener.deleteDish(dish) })
            .create()
    }
}