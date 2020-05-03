package groshevdg.foodex.ui.mainActivity.client

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import groshevdg.foodex.R
import kotlinx.android.synthetic.main.activity_client_main.*

class ClientMainActivity : AppCompatActivity() {

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
}
