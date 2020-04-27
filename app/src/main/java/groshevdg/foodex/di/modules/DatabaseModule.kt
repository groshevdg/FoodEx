package groshevdg.foodex.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import groshevdg.foodex.data.db.database.AppDatabase
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "appDatabase").build()
    }
}