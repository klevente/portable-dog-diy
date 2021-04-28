package dev.klevente.portabledogdiy.data

import dev.klevente.portabledogdiy.domain.MassUnit
import dev.klevente.portabledogdiy.domain.TemperatureUnit
import dev.klevente.portabledogdiy.domain.VolumeUnit

fun String.toMassUnit() = when(this) {
    "kilograms" -> MassUnit.KG
    "grams" -> MassUnit.G
    "pounds" -> MassUnit.LBS
    else -> throw IllegalArgumentException("String $this not valid mass unit!")
}

fun String.toTemperatureUnit() = when(this) {
    "celsius" -> TemperatureUnit.C
    "fahrenheit" -> TemperatureUnit.F
    else -> throw IllegalArgumentException("String $this not valid temperature unit!")
}

fun String.toVolumeUnit() = when(this) {
    "litres" -> VolumeUnit.L
    "gallons" -> VolumeUnit.GAL
    else -> throw IllegalArgumentException("String $this not valid volume unit!")
}