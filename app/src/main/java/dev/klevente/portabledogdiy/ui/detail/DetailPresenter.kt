package dev.klevente.portabledogdiy.ui.detail

import dev.klevente.portabledogdiy.domain.BeerInteractor
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val beerInteractor: BeerInteractor,
) {
    suspend fun loadBeer(id: String) {
        TODO("Not yet implemented")
    }

    suspend fun deleteBeer() {
        TODO("Not yet implemented")
    }
}