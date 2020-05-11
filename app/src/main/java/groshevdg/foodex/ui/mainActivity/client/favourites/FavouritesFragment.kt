package groshevdg.foodex.ui.mainActivity.client.favourites

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
import groshevdg.foodex.model.Dish
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishWasSelected
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishesRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_favourites.*
import javax.inject.Inject

class FavouritesFragment : Fragment() {

    private val adapter = DishesRecyclerAdapter()
    @Inject lateinit var factory: ViewModelFactory
    private lateinit var viewModel: FavouritesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(FavouritesViewModel::class.java)
        viewModel.getMyFavourites()
        adapter.setDishListener(activity as DishWasSelected)
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ffDishesRecyclerView.adapter = adapter
        ffDishesRecyclerView.layoutManager = GridLayoutManager(context, 2)

        viewModel.favourites.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                ffNoElementsInRecycler.visibility = View.VISIBLE
                ffDishesRecyclerView.visibility = View.GONE
            }
            else {
                ffDishesRecyclerView.visibility = View.VISIBLE
                ffNoElementsInRecycler.visibility = View.GONE
                adapter.setData(it.map { it.dish })
            }
        })
    }
}