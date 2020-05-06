package groshevdg.foodex.ui.mainActivity.restorator.dishes

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import groshevdg.foodex.App

import groshevdg.foodex.R
import groshevdg.foodex.di.factory.ViewModelFactory
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.restorator.dishes.adapter.DishesRecyclerAdapter
import groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog.CreateNewDishDialog
import groshevdg.foodex.ui.mainActivity.restorator.dishes.dialog.OnDialogButtonClickListener
import kotlinx.android.synthetic.main.fragment_restorator_dishes.*
import kotlinx.android.synthetic.main.fragment_restorator_dishes.view.*
import kotlinx.android.synthetic.main.fragment_restorator_dishes.view.frdNoElementsInRecycler
import javax.inject.Inject

class DishesFragment : Fragment(), OnDialogButtonClickListener {

    private lateinit var viewModel: DishesViewModel
    private lateinit var fragmentView: View
    @Inject lateinit var factory: ViewModelFactory
    private lateinit var restaurant: Restaurant
    private val adapter = DishesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.plusFragmentComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(DishesViewModel::class.java)
        restaurant = arguments?.getSerializable("restaurant") as Restaurant
        viewModel.getDishes(restaurant.id!!)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {

        fragmentView = inflater.inflate(R.layout.fragment_restorator_dishes, container, false)
        fragmentView.frdDishesRecyclerView.adapter = adapter
        fragmentView.frdDishesRecyclerView.layoutManager = LinearLayoutManager(context)
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.title = "Меню для " + restaurant.name
        return fragmentView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.dishes.observe(viewLifecycleOwner, Observer { list ->
            if (list.isEmpty()) {
                frdDishesRecyclerView.visibility = View.GONE
                frdNoElementsInRecycler.visibility = View.VISIBLE
            }
            else {
                frdDishesRecyclerView.visibility = View.VISIBLE
                frdNoElementsInRecycler.visibility = View.GONE
                adapter.setData(list)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.restorator_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.addItem -> {
                val dialog = CreateNewDishDialog(this)
                dialog.isCancelable = false
                dialog.show(activity?.supportFragmentManager!!, "dishDialog")
                true
            }
            else -> false
        }
    }

    override fun buttonIsClicked(dish: Dish) {
        dish.restaurantId = restaurant.id!!
        viewModel.saveDishInBD(dish)
    }
}
