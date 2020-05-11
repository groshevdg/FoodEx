package groshevdg.foodex.di.components

import dagger.Subcomponent
import groshevdg.foodex.di.modules.ActivityModule
import groshevdg.foodex.di.scopes.FragmentScope
import groshevdg.foodex.ui.login.LoginAsClientFragment
import groshevdg.foodex.ui.login.LoginAsRestoratorFragment
import groshevdg.foodex.ui.mainActivity.client.detalize.DishDetalizeFragment
import groshevdg.foodex.ui.mainActivity.client.detalize.RestaurantDetalizeFragment
import groshevdg.foodex.ui.mainActivity.client.dishesList.DishesListFragment
import groshevdg.foodex.ui.mainActivity.client.favourites.FavouritesFragment
import groshevdg.foodex.ui.mainActivity.client.favourites.FavouritesViewModel
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
    fun inject(fragment: DishesListFragment)
    fun inject(fragment: groshevdg.foodex.ui.mainActivity.client.restaurants.RestaurantsFragment)
    fun inject(fragment: RestaurantDetalizeFragment)
    fun inject(fragment: FavouritesFragment)
    fun inject(fragment: DishDetalizeFragment)
}