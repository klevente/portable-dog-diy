package dev.klevente.portabledogdiy.domain

data class Volume(
    var value: Double,
    var unit: VolumeUnit
)

enum class VolumeUnit(val unit: String, val abbreviation: String) {
    L("litres", "l"), GAL("gallons", "gal");


    override fun toString() = abbreviation
}