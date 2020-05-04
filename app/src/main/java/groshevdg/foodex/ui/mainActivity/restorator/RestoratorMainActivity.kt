package groshevdg.foodex.ui.mainActivity.restorator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import groshevdg.foodex.R
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.restorator.dishes.DishesFragment
import groshevdg.foodex.ui.mainActivity.restorator.restourants.RestaurantsFragment
import groshevdg.foodex.ui.mainActivity.restorator.restourants.adapter.SelectedRestaurantListener
import kotlinx.android.synthetic.main.activity_restorator_main.*

class RestoratorMainActivity : AppCompatActivity(), SelectedRestaurantListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restorator_main)

        setSupportActionBar(armToolbar)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)

        supportFragmentManager.beginTransaction()
            .add(R.id.armContainer, RestaurantsFragment())
            .commit()
    }

    override fun onRestaurantClick(restaurant: Restaurant) {
        val bundle = Bundle()
        bundle.putSerializable("restaurant", restaurant)

        val fragment = DishesFragment()
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.armContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
