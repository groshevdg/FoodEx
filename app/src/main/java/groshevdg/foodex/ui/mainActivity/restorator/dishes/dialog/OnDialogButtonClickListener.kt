package groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog

import groshevdg.foodex.model.Dish

interface OnDialogButtonClickListener {
    fun buttonIsClicked(dish: Dish)
}