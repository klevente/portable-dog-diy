package dev.klevente.portabledogdiy.domain

class Temperature(
    val value: Double,
    val unit: TemperatureUnit
)

enum class TemperatureUnit(val unit: String) {
    C("celsius"), F("fahrenheit");
}
