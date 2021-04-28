package dev.klevente.portabledogdiy.ui.detail

import co.zsmb.rainbowcake.withIOContext
import dev.klevente.portabledogdiy.domain.*
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val beerInteractor: BeerInteractor,
) {
    suspend fun loadBeer(id: Int): DetailedBeer = withIOContext {
        beerInteractor.getBeerById(id).let { beer ->
            DetailedBeer(
                id = beer.id,
                name = beer.name,
                tagline = beer.tagline,
                abv = beer.abv,
                ibu = beer.ibu,
                og = beer.targetOg,
                fg = beer.targetFg,
                volume = beer.volume,
                boilVolume = beer.boilVolume,
                yeast = beer.yeast,
                imageUrl = beer.imageUrl,
                description = beer.description,
                malts = beer.malts,
                hops = beer.hops,
                mash = beer.mash,
                fermentationTemperature = beer.fermentationTemperature
            )
        }
    }

    suspend fun deleteBeer(id: Int) {
        beerInteractor.deleteBeer(id)
    }

    data class DetailedBeer(
        val id: Int,
        val name: String,
        val tagline: String,
        val abv: Double,
        val ibu: Double,
        val og: Double,
        val fg: Double,
        val volume: Volume,
        val boilVolume: Volume,
        val yeast: String,
        val imageUrl: String,
        val description: String,
        val malts: List<Malt>,
        val hops: List<Hop>,
        val mash: List<Mash>,
        val fermentationTemperature: Temperature
    )
}