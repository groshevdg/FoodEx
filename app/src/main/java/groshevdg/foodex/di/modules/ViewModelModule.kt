package groshevdg.foodex.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import groshevdg.foodex.di.factory.ViewModelKey
import groshevdg.foodex.di.scopes.FragmentScope
import groshevdg.foodex.ui.mainActivity.client.detalize.RestaurantDetalizeViewModel
import groshevdg.foodex.ui.mainActivity.client.dishesList.ClientDishesViewModel
import groshevdg.foodex.ui.mainActivity.client.favourites.FavouritesViewModel
import groshevdg.foodex.ui.mainActivity.restorator.dishes.DishesViewModel
import groshevdg.foodex.ui.mainActivity.restorator.restourants.RestaurantsViewModel
import groshevdg.foodex.ui.viewModel.ClientViewModel
import groshevdg.foodex.ui.viewModel.RestoratorViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(ClientViewModel::class)
    abstract fun provideClientViewModel(clientViewModel: ClientViewModel) : ViewModel

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(RestoratorViewModel::class)
    abstract fun provideRestoratorViewModel(clientViewModel: RestoratorViewModel) : ViewModel

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(RestaurantsViewModel::class)
    abstract fun provideRestaurantViewModel(restaurantsViewModel: RestaurantsViewModel) : ViewModel

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(DishesViewModel::class)
    abstract fun provideDishesViewModel(dishesViewModel: DishesViewModel) : ViewModel

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(ClientDishesViewModel::class)
    abstract fun provideClientDishesViewModel(dishesViewModel: ClientDishesViewModel) : ViewModel

    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(RestaurantDetalizeViewModel::class)
    abstract fun provideResDetailizeViewModel(dishesViewModel: RestaurantDetalizeViewModel) : ViewModel


    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(FavouritesViewModel::class)
    abstract fun provideFavouritesViewModel(dishesViewModel: FavouritesViewModel) : ViewModel
}