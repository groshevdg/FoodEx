package groshevdg.foodex.data.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import groshevdg.foodex.data.db.dao.ClientDao
import groshevdg.foodex.data.db.dao.RestoratorDao
import groshevdg.foodex.model.Client
import groshevdg.foodex.model.Restorator

@Database(entities = [Client::class, Restorator::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun restoratorDao(): RestoratorDao
}