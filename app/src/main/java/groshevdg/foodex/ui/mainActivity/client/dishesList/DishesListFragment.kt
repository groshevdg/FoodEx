package groshevdg.foodex.ui.mainActivity.client.dishesList

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
import kotlinx.android.synthetic.main.fragment_dishes_list.view.*
import javax.inject.Inject

class DishesListFragment : Fragment() {

    private lateinit var clientDishesViewModel: ClientDishesViewModel
    private val adapter = DishesRecyclerAdapter()
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        clientDishesViewModel = ViewModelProvider(this, factory).get(ClientDishesViewModel::class.java)
        clientDishesViewModel.getAllDishes()
        adapter.setDishListener(activity as DishWasSelected)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fragmentView = inflater.inflate(R.layout.fragment_dishes_list, container, false)
        fragmentView.fdlDishesRecyclerView.adapter = adapter
        val manager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        fragmentView.fdlDishesRecyclerView.layoutManager = manager

        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        clientDishesViewModel.dishes.observe(viewLifecycleOwner, Observer { list ->
            adapter.setData(list)
        })
    }
}
