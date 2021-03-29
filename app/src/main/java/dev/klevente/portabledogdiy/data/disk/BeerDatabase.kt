package dev.klevente.portabledogdiy.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.klevente.portabledogdiy.data.disk.entities.RoomBeer

@Database(
    entities = [RoomBeer::class],
    version = 1,
    exportSchema = false
)
abstract class BeerDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}