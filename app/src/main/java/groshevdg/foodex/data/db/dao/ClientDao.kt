package groshevdg.foodex.data.db.dao

import androidx.room.*
import groshevdg.foodex.model.Client

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClient(client: Client)

    @Update
    fun updateClient(client: Client)

    @Delete
    fun deleteClient(client: Client)

    @Query("SELECT * FROM client WHERE email = :email AND password = :password")
    fun getClient(email: String, password: String) : Client
}