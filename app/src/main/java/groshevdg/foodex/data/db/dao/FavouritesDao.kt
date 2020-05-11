package groshevdg.foodex.data.db.dao

import androidx.room.*
import groshevdg.foodex.model.Favourite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFavouriteDish(favourite: Favourite)

    @Query("Select * from Favourite")
    fun getFavourites() : Flow<List<Favourite>>

    @Query("select * from Favourite where id = :id")
    fun checkAlreadySaved(id: Int) : Boolean

    @Query("delete from Favourite where id = :id")
    fun deleteFromFavourites(id: Int)
}