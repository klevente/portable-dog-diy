package dev.klevente.portabledogdiy.domain

data class Mass(
    var value: Double,
    var unit: MassUnit
)

enum class MassUnit(val unit: String, val abbreviation: String) {
    KG("kilograms", "kg"), G("grams", "g"), LBS("pounds", "lbs");

    override fun toString() = abbreviation
}