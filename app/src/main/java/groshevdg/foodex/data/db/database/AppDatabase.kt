package groshevdg.foodex.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import groshevdg.foodex.data.db.dao.*
import groshevdg.foodex.model.*

@Database(entities = [Client::class, Restorator::class, Restaurant::class, Dish::class,
    Favourite::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun restoratorDao(): RestoratorDao
    abstract fun restaurantDao() : RestaurantDao
    abstract fun dishDao() : DishDao
    abstract fun favouritesDao() : FavouritesDao
}