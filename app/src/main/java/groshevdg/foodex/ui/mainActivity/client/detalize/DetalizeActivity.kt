package groshevdg.foodex.ui.mainActivity.client.detalize

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishWasSelected

class DetalizeActivity : AppCompatActivity(), DishWasSelected {
    override fun onCreate(savedInstanceState: Bundle?) {
        val dish = intent.getSerializableExtra("dish") as Dish?
        val restaurant = intent.getSerializableExtra("restaurant") as Restaurant?
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalize)
        if (dish != null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.adContainer, DishDetalizeFragment(dish))
                .commit()
        }
        else {
            supportFragmentManager.beginTransaction()
                .add(R.id.adContainer, RestaurantDetalizeFragment(restaurant!!))
                .commit()
        }
    }

    override fun selected(dish: Dish) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.adContainer, DishDetalizeFragment(dish))
            .addToBackStack("")
            .commit()
    }
}