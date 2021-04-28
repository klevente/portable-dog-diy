package dev.klevente.portabledogdiy.domain

data class Temperature(
    var value: Double,
    var unit: TemperatureUnit
)

enum class TemperatureUnit(val unit: String, val abbreviation: String) {
    C("celsius", "°C"), F("fahrenheit", "°F");

    override fun toString() = abbreviation
}