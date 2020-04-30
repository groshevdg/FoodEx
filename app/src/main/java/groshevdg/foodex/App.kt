package groshevdg.foodex

import android.app.Application
import groshevdg.foodex.di.components.AppComponent
import groshevdg.foodex.di.components.DaggerAppComponent
import groshevdg.foodex.di.modules.ContextModule
import groshevdg.foodex.di.modules.DatabaseModule

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule((applicationContext)))
            .databaseModule(DatabaseModule())
            .build()
    }
}