package dev.klevente.portabledogdiy.data.disk.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beer")
data class RoomBeer(
    @PrimaryKey
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String,
    val abv: Double,
    val ibu: Int,
    val targetFg: Int,
    val targetOg: Int,
    val volume: RoomVolume,
    val boilVolume: RoomVolume,
    val mash: List<RoomMash>,
    val fermentationTemperature: RoomTemperature,
    val malts: List<RoomMalt>,
    val hops: List<RoomHop>,
    val yeast: String,
)

class RoomMass(
    val value: Double,
    val unit: String
)

class RoomTemperature(
    val value: Double,
    val unit: String
)

class RoomVolume(
    val value: Double,
    val unit: String
)

class RoomMash(
    val temperature: RoomTemperature,
    val duration: Int
)

class RoomMalt(
    val name: String,
    val amount: RoomMass
)

class RoomHop(
    val name: String,
    val amount: RoomMass,
    val add: String
)