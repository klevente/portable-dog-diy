package dev.klevente.portabledogdiy.data.network

import dev.klevente.portabledogdiy.data.network.model.*
import dev.klevente.portabledogdiy.domain.Beer
import dev.klevente.portabledogdiy.domain.MassUnit
import dev.klevente.portabledogdiy.domain.TemperatureUnit
import dev.klevente.portabledogdiy.domain.VolumeUnit

fun BeerResponse.toDomain() = Beer(
    id = id,
    name = name,
    tagline = tagline,
    description = description,
    imageUrl = imageUrl,
    abv = abv,
    ibu = ibu,
    targetFg = targetFg,
    targetOg = targetOg,
    volume = volume.toDomain(),
    boilVolume = boilVolume.toDomain(),
    mash = method.mashTemp.map(Mash::toDomain),
    fermentationTemperature = method.fermentation.temp.toDomain(),
    malts = ingredients.malt.map(Malt::toDomain),
    hops = ingredients.hops.map(Hop::toDomain),
    yeast = ingredients.yeast
)

fun Mass.toDomain() = dev.klevente.portabledogdiy.domain.Mass(
    value = value,
    unit = unit.toMassUnit()
)

fun Temperature.toDomain() = dev.klevente.portabledogdiy.domain.Temperature(
    value = value,
    unit = unit.toTemperatureUnit()
)

fun Volume.toDomain() = dev.klevente.portabledogdiy.domain.Volume(
    value = value,
    unit = unit.toVolumeUnit()
)

fun Mash.toDomain() = dev.klevente.portabledogdiy.domain.Mash(
    temperature = temp.toDomain(),
    duration = duration
)

fun Malt.toDomain() = dev.klevente.portabledogdiy.domain.Malt(
    name = name,
    amount = amount.toDomain()
)

fun Hop.toDomain() = dev.klevente.portabledogdiy.domain.Hop(
    name = name,
    amount = amount.toDomain(),
    add = add
)

fun String.toMassUnit() = when(this) {
    "kilograms" -> MassUnit.KG
    "grams" -> MassUnit.G
    "pounds" -> MassUnit.LBS
    else -> throw IllegalArgumentException("String not valid mass unit!")
}

fun String.toTemperatureUnit() = when(this) {
    "celsius" -> TemperatureUnit.C
    "fahrenheit" -> TemperatureUnit.F
    else -> throw IllegalArgumentException("String not valid temperature unit!")
}

fun String.toVolumeUnit() = when(this) {
    "litres" -> VolumeUnit.L
    "gallons" -> VolumeUnit.GAL
    else -> throw IllegalArgumentException("String not valid volume unit!")
}