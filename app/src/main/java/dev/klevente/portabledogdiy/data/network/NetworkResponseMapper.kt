package dev.klevente.portabledogdiy.data.network

import dev.klevente.portabledogdiy.data.network.models.*
import dev.klevente.portabledogdiy.data.toMassUnit
import dev.klevente.portabledogdiy.data.toTemperatureUnit
import dev.klevente.portabledogdiy.data.toVolumeUnit
import dev.klevente.portabledogdiy.domain.Beer

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