package dev.klevente.portabledogdiy.domain

class Volume(
    val value: Double,
    val unit: VolumeUnit
)

enum class VolumeUnit(val unit: String) {
    L("litres"), GAL("gallons")
}
