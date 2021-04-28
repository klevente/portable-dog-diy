package dev.klevente.portabledogdiy.ui.edit

import co.zsmb.rainbowcake.withIOContext
import dev.klevente.portabledogdiy.domain.*
import javax.inject.Inject

class EditPresenter @Inject constructor(
    private val beerInteractor: BeerInteractor,
) {
    suspend fun loadBeer(id: Int): EditBeer = withIOContext {
        beerInteractor.getBeerById(id).let { beer ->
            EditBeer(
                id = beer.id,
                name = beer.name,
                tagline = beer.tagline,
                abv = beer.abv.toString(),
                ibu = beer.ibu.toString(),
                og = beer.targetOg.toString(),
                fg = beer.targetFg.toString(),
                volume = beer.volume.value.toString(),
                boilVolume = beer.boilVolume.value.toString(),
                yeast = beer.yeast,
                description = beer.description,
                malts = beer.malts.map { it.toEditMalt() }.toMutableList(),
                hops = beer.hops.map { it.toEditHop() }.toMutableList(),
                mash = beer.mash.map { it.toEditMash() }.toMutableList(),
                fermentationTemperatureQuantity = beer.fermentationTemperature.value.toString(),
                fermentationTemperatureOrdinal = beer.fermentationTemperature.unit.ordinal
            )
        }
    }

    fun createNewBeer() = EditBeer(
        id = -1,
        name = "",
        tagline = "",
        abv = "0.0",
        ibu = "0.0",
        og = "1000.0",
        fg = "1000.0",
        volume = "0.0",
        boilVolume = "0.0",
        yeast = "",
        description = "",
        malts = mutableListOf(),
        hops = mutableListOf(),
        mash = mutableListOf(),
        fermentationTemperatureQuantity = "0.0",
        fermentationTemperatureOrdinal = 0
    )

    suspend fun addBeer(beer: EditBeer) {
        beerInteractor.addBeer(beer.toDomain())
    }

    suspend fun updateBeer(beer: EditBeer) {
        beerInteractor.updateBeer(beer.toDomain())
    }

    data class EditBeer(
        val id: Int,
        var name: String,
        var tagline: String,
        var abv: String,
        var ibu: String,
        var og: String,
        var fg: String,
        var volume: String,
        var boilVolume: String,
        var yeast: String,
        var description: String,
        val malts: MutableList<EditMalt>,
        val hops: MutableList<EditHop>,
        val mash: MutableList<EditMash>,
        var fermentationTemperatureQuantity: String,
        var fermentationTemperatureOrdinal: Int
    )

    data class EditMalt(
        var name: String,
        var quantity: String,
        var unitOrdinal: Int
    )

    data class EditHop(
        var name: String,
        var quantity: String,
        var unitOrdinal: Int,
        var add: String
    )

    data class EditMash(
        var temperatureQuantity: String,
        var temperatureUnitOrdinal: Int,
        var duration: String
    )

    private fun Malt.toEditMalt() = EditMalt(
        name = name,
        quantity = amount.value.toString(),
        unitOrdinal = amount.unit.ordinal
    )

    private fun Hop.toEditHop() = EditHop(
        name = name,
        quantity = amount.value.toString(),
        unitOrdinal = amount.unit.ordinal,
        add = add
    )

    private fun Mash.toEditMash() = EditMash(
        temperatureQuantity = temperature.value.toString(),
        temperatureUnitOrdinal = temperature.unit.ordinal,
        duration = duration.toString()
    )

    private fun EditBeer.toDomain() = Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        imageUrl = "https://images.punkapi.com/v2/keg.png",
        abv = abv.toDouble(),
        ibu = ibu.toDouble(),
        targetOg = og.toDouble(),
        targetFg = fg.toDouble(),
        volume = Volume(volume.toDouble(), VolumeUnit.L),
        boilVolume = Volume(boilVolume.toDouble(), VolumeUnit.L),
        yeast = yeast,
        malts = malts.map { it.toMalt() },
        hops = hops.map { it.toHop() },
        mash = mash.map { it.toMash() },
        fermentationTemperature = parseTemperature(fermentationTemperatureQuantity, fermentationTemperatureOrdinal)
    )

    private fun EditMalt.toMalt() = Malt(
        name = name,
        amount = parseMass(quantity, unitOrdinal)
    )

    private fun EditHop.toHop() = Hop(
        name = name,
        amount = parseMass(quantity, unitOrdinal),
        add = add
    )

    fun EditMash.toMash() = Mash(
        temperature = parseTemperature(temperatureQuantity, temperatureUnitOrdinal),
        duration = duration.toInt()
    )

    private fun parseMass(value: String, unitOrdinal: Int) = Mass(value.toDouble(), MassUnit.values()[unitOrdinal])
    private fun parseTemperature(value: String, unitOrdinal: Int) = Temperature(value.toDouble(), TemperatureUnit.values()[unitOrdinal])
}