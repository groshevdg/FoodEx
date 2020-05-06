package groshevdg.foodex.ui.mainActivity.client.restaurants

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import groshevdg.foodex.App
import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.ui.mainActivity.client.dishesList.ClientDishesViewModel
import groshevdg.foodex.ui.mainActivity.client.restaurants.adapter.ClientRestaurantsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_client_restaurants.view.*
import javax.inject.Inject

class RestaurantsFragment : Fragment() {
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory
    private lateinit var viewModel: ClientDishesViewModel
    private val adapter = ClientRestaurantsRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this,factory).get(ClientDishesViewModel::class.java)
        viewModel.getAllRestaurants()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_client_restaurants, container, false)
        fragmentView.frRestaurantsRecyclerView.adapter = adapter
        fragmentView.frRestaurantsRecyclerView.layoutManager = LinearLayoutManager(context)
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.restaurants.observe(viewLifecycleOwner, Observer { list ->
            adapter.setData(list)
        })
    }
}