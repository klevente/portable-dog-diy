package dev.klevente.portabledogdiy.data.disk

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.klevente.portabledogdiy.data.disk.entities.RoomBeer

@Dao
interface BeerDao {
    @Query("select * from beer")
    suspend fun getAllBeers(): List<RoomBeer>

    @Query("select * from beer where id = :id")
    suspend fun getBeerById(id: Int): RoomBeer?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBeer(vararg roomBeer: RoomBeer)

    @Query("delete from beer where id = :id")
    suspend fun deleteBeer(id: Int)
}