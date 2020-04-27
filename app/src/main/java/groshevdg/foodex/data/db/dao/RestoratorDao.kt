package groshevdg.foodex.data.db.dao

import androidx.room.*
import groshevdg.foodex.model.Restorator

@Dao
interface RestoratorDao {

    @Query("SELECT * FROM restorator WHERE email = :email AND password = :password")
    fun getRetorator(email: String, password: String) : Restorator

    @Insert
    fun insertRestorator(restorator: Restorator)

    @Update
    fun updateRestorator(restorator: Restorator)

    @Delete
    fun deleteRestorator(restorator: Restorator)
}