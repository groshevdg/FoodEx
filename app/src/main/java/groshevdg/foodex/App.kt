package groshevdg.foodex

import android.app.Application
import groshevdg.foodex.di.components.AppComponent
import groshevdg.foodex.di.components.DaggerAppComponent

object App : Application() {
    lateinit var app: App
    private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent = DaggerAppComponent.create()
    }

    fun getAppComponent() : AppComponent {
        return appComponent
    }
}