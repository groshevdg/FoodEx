package groshevdg.foodex.di.components

import dagger.Component
import groshevdg.foodex.App
import groshevdg.foodex.di.modules.ContextModule
import groshevdg.foodex.di.modules.DatabaseModule
import groshevdg.foodex.di.modules.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, DatabaseModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(app: App)
    fun plusFragmentComponent() : FragmentComponent
}