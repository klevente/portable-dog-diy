package dev.klevente.portabledogdiy.data.network

import dev.klevente.portabledogdiy.data.network.model.BeerAddRequest
import dev.klevente.portabledogdiy.data.network.model.Fermentation
import dev.klevente.portabledogdiy.data.network.model.Ingredients
import dev.klevente.portabledogdiy.data.network.model.Method
import dev.klevente.portabledogdiy.domain.*

fun Beer.toRequest() = BeerAddRequest(
    name = name,
    tagline = tagline,
    description = description,
    imageUrl = imageUrl,
    abv = abv,
    ibu = ibu,
    targetFg = targetFg,
    targetOg = targetOg,
    volume = volume.toRequest(),
    boilVolume = boilVolume.toRequest(),
    method = Method(
        mashTemp = mash.map(Mash::toRequest),
        fermentation = Fermentation(temp = fermentationTemperature.toRequest())
    ),
    ingredients = Ingredients(
        malt = malts.map(Malt::toRequest),
        hops = hops.map(Hop::toRequest),
        yeast = yeast
    )
)

fun Mass.toRequest() = dev.klevente.portabledogdiy.data.network.model.Mass(
    value = value,
    unit = unit.unit
)

fun Temperature.toRequest() = dev.klevente.portabledogdiy.data.network.model.Temperature(
    value = value,
    unit = unit.unit
)

fun Volume.toRequest() = dev.klevente.portabledogdiy.data.network.model.Volume(
    value = value,
    unit = unit.unit
)

fun Mash.toRequest() = dev.klevente.portabledogdiy.data.network.model.Mash(
    temp = temperature.toRequest(),
    duration = duration
)

fun Malt.toRequest() = dev.klevente.portabledogdiy.data.network.model.Malt(
    name = name,
    amount = amount.toRequest()
)

fun Hop.toRequest() = dev.klevente.portabledogdiy.data.network.model.Hop(
    name = name,
    amount = amount.toRequest(),
    add = add
)
