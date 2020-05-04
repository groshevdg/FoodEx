package groshevdg.foodex.ui.mainActivity.restorator.restourants

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import groshevdg.foodex.App

import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter.RestoratorRecyclerAdapter
import groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter.SelectedRestaurantListener
import groshevdg.foodex.ui.mainActivity.restorator.restourants.dialog.OnDialogButtonClickListener
import groshevdg.foodex.ui.mainActivity.restorator.restourants.dialog.RegisterNewRestaurantDialog
import kotlinx.android.synthetic.main.fragment_restorator_restourants.*
import kotlinx.android.synthetic.main.fragment_restorator_restourants.view.*
import kotlinx.android.synthetic.main.fragment_restorator_restourants.view.frRestaurantsRecyclerView
import javax.inject.Inject

class RestaurantsFragment : Fragment(), OnDialogButtonClickListener {

    private lateinit var viewModel: RestaurantsViewModel
    private val adapter = RestoratorRecyclerAdapter()
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(RestaurantsViewModel::class.java)
        viewModel.getRestaurants(App.restorator.id!!)
        adapter.addListener(activity as SelectedRestaurantListener)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        fragmentView = inflater.inflate(R.layout.fragment_restorator_restourants, container, false)
        fragmentView.frRestaurantsRecyclerView.adapter = adapter
        fragmentView.frRestaurantsRecyclerView.layoutManager = LinearLayoutManager(context)

        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.restaurants.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                frRestaurantsRecyclerView.visibility = View.INVISIBLE
            }
            else {
                adapter.setData(it)
                frrNoElementsInRecycler.visibility = View.GONE
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.restorator_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.addItem) {
            createNewRestaurant()
            true
        } else false
    }

    private fun createNewRestaurant() {
        val dialog = RegisterNewRestaurantDialog(this)
        dialog.isCancelable = false
        dialog.show(requireActivity().supportFragmentManager, "register")
    }

    override fun onCreateButtonWasClicked(restaurant: Restaurant) {
        restaurant.restoratorId = App.restorator.id!!
        viewModel.saveRestaurantIntoBD(restaurant)
    }
}
