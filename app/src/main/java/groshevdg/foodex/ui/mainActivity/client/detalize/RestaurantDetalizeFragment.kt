package groshevdg.foodex.ui.mainActivity.client.detalize

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishWasSelected
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishesRecyclerAdapter
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.loadImage
import kotlinx.android.synthetic.main.fragment_restaurant_detalize.*
import javax.inject.Inject

class RestaurantDetalizeFragment(val restaurant: Restaurant) : Fragment() {
    val adapter = DishesRecyclerAdapter()
    @Inject lateinit var factory: ViewModelFactory
    lateinit var viewModel: RestaurantDetalizeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(RestaurantDetalizeViewModel::class.java)
        viewModel.getDishes(restaurant)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        adapter.setDishListener(activity as DishWasSelected)
        return inflater.inflate(R.layout.fragment_restaurant_detalize, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        frdNameTextView.text = restaurant.name
        frdPhotoImageView.loadImage(requireContext(), restaurant.photo)
        frdPositionTextView.text = restaurant.address
        frdDishesRecyclerView.adapter = adapter
        frdDishesRecyclerView.layoutManager = GridLayoutManager(context, 2)

        viewModel.dishes.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }
}