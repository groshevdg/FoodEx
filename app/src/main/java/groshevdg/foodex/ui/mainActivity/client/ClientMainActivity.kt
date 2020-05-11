package groshevdg.foodex.ui.mainActivity.client

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import groshevdg.foodex.R
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Restaurant
import groshevdg.foodex.ui.basket.BasketActivity
import groshevdg.foodex.ui.mainActivity.client.detalize.DetalizeActivity
import groshevdg.foodex.ui.mainActivity.client.detalize.DishDetalizeFragment
import groshevdg.foodex.ui.mainActivity.client.detalize.RestaurantDetalizeFragment
import groshevdg.foodex.ui.mainActivity.client.dishesList.adapter.DishWasSelected
import groshevdg.foodex.ui.mainActivity.client.restaurants.adapter.RestaurantWasSelectedListener
import kotlinx.android.synthetic.main.activity_client_main.*

class ClientMainActivity : AppCompatActivity(), DishWasSelected, RestaurantWasSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main)
        setSupportActionBar(toolbar)
        window.statusBarColor = ContextCompat.getColor(applicationContext, R.color.colorPrimaryDark)
        val navView: BottomNavigationView = findViewById(R.id.client_nav_view)

        val navController = findNavController(R.id.client_nav_host_fragment)
        navView.setupWithNavController(navController)

        navView.setOnNavigationItemSelectedListener { item -> when(item.itemId) {
                R.id.dishes_list -> {
                    navController.navigate(R.id.nav_dishes_list)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.choose_restaurant -> {
                    navController.navigate(R.id.nav_restaurants)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    navController.navigate(R.id.nav_favourites)
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.client_basket, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.basket) {
            startActivity(Intent(this, BasketActivity::class.java))
            true
        }
        else false
    }

    override fun selected(dish: Dish) {
        val intent = Intent(this, DetalizeActivity::class.java)
        intent.putExtra("dish", dish)
        startActivity(intent)
    }

    override fun selected(restaurant: Restaurant) {
        val intent = Intent(this, DetalizeActivity::class.java)
        intent.putExtra("restaurant", restaurant)
        startActivity(intent)
    }
}
