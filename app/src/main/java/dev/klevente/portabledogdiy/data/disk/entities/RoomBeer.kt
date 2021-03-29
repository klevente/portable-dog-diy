package dev.klevente.portabledogdiy.data.disk.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beer")
class RoomBeer(
    @PrimaryKey
    val id: String,
)