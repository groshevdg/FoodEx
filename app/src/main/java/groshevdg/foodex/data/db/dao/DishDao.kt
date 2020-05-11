package groshevdg.foodex.data.db.dao

import androidx.room.*
import groshevdg.foodex.model.Dish
import kotlinx.coroutines.flow.Flow

@Dao
interface DishDao {

    @Query("Select * from Dish where restaurantId = :resId")
    fun getDish(resId: Int) : Flow<List<Dish>>

    @Query("Select * from Dish")
    fun getAllDishes() : Flow<List<Dish>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDish(dish: Dish)

    @Update
    fun updateDish(dish: Dish)

    @Delete
    fun deleteDish(dish: Dish)
}