package dev.klevente.portabledogdiy.domain

class Mass(
    val value: Double,
    val unit: MassUnit
)

enum class MassUnit(val unit: String) {
    KG("kilograms"), G("grams"), LBS("pounds")
}
