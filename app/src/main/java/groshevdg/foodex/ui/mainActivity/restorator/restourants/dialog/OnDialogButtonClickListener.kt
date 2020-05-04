package groshevdg.foodex.ui.mainActivity.restorator.restourants.dialog

import groshevdg.foodex.model.Restaurant

interface OnDialogButtonClickListener {
    fun onCreateButtonWasClicked(restaurant: Restaurant)
}