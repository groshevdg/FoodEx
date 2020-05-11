package groshevdg.foodex.ui.mainActivity.client.detalize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Favourite
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.loadImage
import groshevdg.foodex.ui.mainActivity.client.favourites.FavouritesViewModel
import kotlinx.android.synthetic.main.fragment_detalize.*
import javax.inject.Inject

class DishDetalizeFragment(val dish: Dish) : Fragment() {

    @Inject lateinit var factory: ViewModelFactory
    private lateinit var viewModel: FavouritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(FavouritesViewModel::class.java)
        viewModel.checkDishHasAdded(dish)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
       return inflater.inflate(R.layout.fragment_detalize, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val a = App.selectedDishes.find { it.id == dish.id }
        if (a != null) {
            fdRemoveToBasketButton.visibility = View.VISIBLE
            fdRemoveToBasketButton.setOnClickListener { v ->
                App.selectedDishes.remove(a)
                fdRemoveToBasketButton.visibility = View.GONE
                fdAddToBasketButton.visibility = View.VISIBLE
                fdAddToBasketButton.setOnClickListener {
                    App.selectedDishes.add(dish)
                    fdRemoveToBasketButton.visibility = View.VISIBLE
                    fdAddToBasketButton.visibility = View.GONE
                }
            }
        }
        else {
            fdAddToBasketButton.visibility = View.VISIBLE
            fdAddToBasketButton.setOnClickListener { v ->
                App.selectedDishes.add(dish)
                fdAddToBasketButton.visibility = View.GONE
                fdRemoveToBasketButton.visibility = View.VISIBLE
                fdRemoveToBasketButton.setOnClickListener { v ->
                    App.selectedDishes.remove(dish)
                    fdRemoveToBasketButton.visibility = View.GONE
                    fdAddToBasketButton.visibility = View.VISIBLE
                }
            }
        }

        viewModel.saved.observe(viewLifecycleOwner, Observer {
            if (it) {
                fdAddFavourite.visibility = View.GONE
                fdRemoveFavourite.visibility = View.VISIBLE
                fdRemoveFavourite.setOnClickListener { v ->
                    viewModel.removeFromFavourites(dish)
                    fdAddFavourite.visibility = View.VISIBLE
                    fdRemoveFavourite.visibility = View.GONE

                    fdAddFavourite.setOnClickListener { v ->
                        viewModel.addFavourite(Favourite(dish))
                        fdAddFavourite.visibility = View.GONE
                        fdRemoveFavourite.visibility = View.VISIBLE
                    }
                }
            } else {
                fdAddFavourite.setOnClickListener { v ->
                    viewModel.addFavourite(Favourite(dish))
                    fdAddFavourite.visibility = View.GONE
                    fdRemoveFavourite.visibility = View.VISIBLE

                    fdRemoveFavourite.setOnClickListener { v ->
                        viewModel.removeFromFavourites(dish)
                        fdAddFavourite.visibility = View.VISIBLE
                        fdRemoveFavourite.visibility = View.GONE
                    }
                }
            }

            fdDishNameTextView.text = dish.name
            fdPhotoImageView.loadImage(requireContext(), dish.image)
            fdDescriptionTextView.text = dish.description
            fdPriceTextView.text = dish.price
            fdWeightTextView.text = dish.weight

        })
    }
}
