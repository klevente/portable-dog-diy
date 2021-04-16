package dev.klevente.portabledogdiy.data.disk

import dev.klevente.portabledogdiy.data.disk.entities.*
import dev.klevente.portabledogdiy.data.toMassUnit
import dev.klevente.portabledogdiy.data.toTemperatureUnit
import dev.klevente.portabledogdiy.data.toVolumeUnit
import dev.klevente.portabledogdiy.domain.*

fun Beer.toRoomBeer() = RoomBeer(
    id = id,
    name = name,
    tagline = tagline,
    description = description,
    imageUrl = imageUrl,
    abv = abv,
    ibu = ibu,
    targetFg = targetFg,
    targetOg = targetOg,
    volume = volume.toRoomVolume(),
    boilVolume = boilVolume.toRoomVolume(),
    mash = mash.map(Mash::toRoomMash),
    fermentationTemperature = fermentationTemperature.toRoomTemperature(),
    malts = malts.map(Malt::toRoomMalt),
    hops = hops.map(Hop::toRoomHop),
    yeast = yeast
)

fun Mass.toRoomMass() = RoomMass(
    value = value,
    unit = unit.unit
)

fun Temperature.toRoomTemperature() = RoomTemperature(
    value = value,
    unit = unit.unit
)

fun Volume.toRoomVolume() = RoomVolume(
    value = value,
    unit = unit.unit
)

fun Mash.toRoomMash() = RoomMash(
    temperature = temperature.toRoomTemperature(),
    duration = duration
)

fun Malt.toRoomMalt() = RoomMalt(
    name = name,
    amount = amount.toRoomMass()
)

fun Hop.toRoomHop() = RoomHop(
    name = name,
    amount = amount.toRoomMass(),
    add = add
)

fun RoomBeer.toBeer() = Beer(
    id = id,
    name = name,
    tagline = tagline,
    description = description,
    imageUrl = imageUrl,
    abv = abv,
    ibu = ibu,
    targetFg = targetFg,
    targetOg = targetOg,
    volume = volume.toVolume(),
    boilVolume = boilVolume.toVolume(),
    mash = mash.map(RoomMash::toMash),
    fermentationTemperature = fermentationTemperature.toTemperature(),
    malts = malts.map(RoomMalt::toMalt),
    hops = hops.map(RoomHop::toHop),
    yeast = yeast
)

fun RoomMass.toMass() = Mass(
    value = value,
    unit = unit.toMassUnit()
)

fun RoomTemperature.toTemperature() = Temperature(
    value = value,
    unit = unit.toTemperatureUnit()
)

fun RoomVolume.toVolume() = Volume(
    value = value,
    unit = unit.toVolumeUnit()
)

fun RoomMash.toMash() = Mash(
    temperature = temperature.toTemperature(),
    duration = duration
)

fun RoomMalt.toMalt() = Malt(
    name = name,
    amount = amount.toMass()
)

fun RoomHop.toHop() = Hop(
    name = name,
    amount = amount.toMass(),
    add = add
)