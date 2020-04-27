package groshevdg.foodex.di.components

import dagger.Component
import groshevdg.foodex.App
import groshevdg.foodex.di.modules.ContextModule
import groshevdg.foodex.di.modules.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(app: App)
}