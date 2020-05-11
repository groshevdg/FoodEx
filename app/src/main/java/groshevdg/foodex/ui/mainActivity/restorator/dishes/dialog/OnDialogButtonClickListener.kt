package groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog

import groshevdg.foodex.model.Dish

interface OnDialogButtonClickListener {
    fun saveDish(dish: Dish)
    fun refactorDish(dish: Dish)
    fun deleteDish(dish: Dish)
}