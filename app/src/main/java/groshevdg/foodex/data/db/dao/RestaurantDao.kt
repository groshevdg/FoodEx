package groshevdg.foodex.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import groshevdg.foodex.model.Restaurant
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("Select * from Restaurant where restoratorId = :resId")
    fun getRestaurants(resId: Long) : Flow<List<Restaurant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRestaurant(restaurant: Restaurant)

    @Query("Select * from Restaurant")
    fun getAllRestaurants() : Flow<List<Restaurant>>
}