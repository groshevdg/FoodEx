package groshevdg.foodex.di.components

import dagger.Subcomponent
import groshevdg.foodex.di.modules.ActivityModule
import groshevdg.foodex.di.scopes.FragmentScope
import groshevdg.foodex.ui.login.LoginAsClientFragment
import groshevdg.foodex.ui.login.LoginAsRestoratorFragment
import groshevdg.foodex.ui.mainActivity.restorator.dishes.DishesFragment
import groshevdg.foodex.ui.mainActivity.restorator.restourants.RestaurantsFragment
import groshevdg.foodex.ui.register.RegisterAsClientFragment
import groshevdg.foodex.ui.register.RegisterAsRestoratorFragment

@FragmentScope
@Subcomponent(modules = [ActivityModule::class])
interface FragmentComponent {
    fun inject(fragment: LoginAsClientFragment)
    fun inject(fragment: LoginAsRestoratorFragment)
    fun inject(fragment: RegisterAsClientFragment)
    fun inject(fragment: RegisterAsRestoratorFragment)
    fun inject(fragment: RestaurantsFragment)
    fun inject(fragment: DishesFragment)
}