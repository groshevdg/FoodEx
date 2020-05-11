package groshevdg.foodex

import android.app.Application
import groshevdg.foodex.di.components.AppComponent
import groshevdg.foodex.di.components.DaggerAppComponent
import groshevdg.foodex.di.modules.ContextModule
import groshevdg.foodex.di.modules.DatabaseModule
import groshevdg.foodex.model.Dish
import groshevdg.foodex.model.Restorator

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var restorator: Restorator
        val selectedDishes = ArrayList<Dish>()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule((applicationContext)))
            .databaseModule(DatabaseModule())
            .build()
    }
}