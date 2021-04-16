package dev.klevente.portabledogdiy.data.disk

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.klevente.portabledogdiy.data.disk.entities.*


class JsonTypeConverter {
    private val gson = Gson()

    @TypeConverter
    fun stringToRoomVolume(value: String): RoomVolume = gson.fromJson(value, RoomVolume::class.java)

    @TypeConverter
    fun roomVolumeToString(value: RoomVolume): String = gson.toJson(value)

    @TypeConverter
    fun stringToListOfRoomMash(value: String): List<RoomMash> =
        gson.fromJson(value, object : TypeToken<List<RoomMash>>() {}.type)

    @TypeConverter
    fun listOfRoomMashToString(value: List<RoomMash>): String = gson.toJson(value)

    @TypeConverter
    fun stringToRoomTemperature(value: String): RoomTemperature = gson.fromJson(value, RoomTemperature::class.java)

    @TypeConverter
    fun roomTemperatureToString(value: RoomTemperature): String = gson.toJson(value)

    @TypeConverter
    fun stringToListOfRoomMalt(value: String): List<RoomMalt> =
        gson.fromJson(value, object : TypeToken<List<RoomMalt>>() {}.type)

    @TypeConverter
    fun listOfRoomMaltToString(value: List<RoomMalt>): String = gson.toJson(value)

    @TypeConverter
    fun stringToListOfRoomHop(value: String): List<RoomHop> =
        gson.fromJson(value, object : TypeToken<List<RoomHop>>() {}.type)

    @TypeConverter
    fun listOfRoomHopToString(value: List<RoomHop>): String = gson.toJson(value)
}