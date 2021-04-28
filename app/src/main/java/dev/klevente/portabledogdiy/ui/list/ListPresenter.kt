package dev.klevente.portabledogdiy.ui.list

import co.zsmb.rainbowcake.withIOContext
import dev.klevente.portabledogdiy.domain.BeerInteractor
import dev.klevente.portabledogdiy.domain.Volume
import javax.inject.Inject

class ListPresenter @Inject constructor(
    private val beerInteractor: BeerInteractor,
) {
    suspend fun loadBeers(): List<BeerItem> = withIOContext {
        beerInteractor.getBeers().map { beer ->
            BeerItem(
                id = beer.id,
                name = beer.name,
                tagline = beer.tagline,
                abv = beer.abv,
                ibu = beer.ibu,
                og = beer.targetOg,
                fg = beer.targetFg,
                volume = beer.volume,
                boilVolume = beer.boilVolume,
                imageUrl = beer.imageUrl
            )
        }
    }

    data class BeerItem(
        val id: Int,
        val name: String,
        val tagline: String,
        val abv: Double,
        val ibu: Double,
        val og: Double,
        val fg: Double,
        val volume: Volume,
        val boilVolume: Volume,
        val imageUrl: String
    )
}