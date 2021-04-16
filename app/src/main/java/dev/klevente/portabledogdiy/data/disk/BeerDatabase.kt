package dev.klevente.portabledogdiy.data.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.klevente.portabledogdiy.data.disk.entities.RoomBeer

@Database(
    entities = [RoomBeer::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(JsonTypeConverter::class)
abstract class BeerDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}