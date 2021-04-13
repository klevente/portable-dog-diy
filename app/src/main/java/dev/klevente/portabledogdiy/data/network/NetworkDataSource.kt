package dev.klevente.portabledogdiy.data.network

import dev.klevente.portabledogdiy.data.network.model.BeerResponse
import dev.klevente.portabledogdiy.domain.Beer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val punkApi: PunkApi,
) {
    suspend fun getBeers(): List<Beer> {
        return punkApi.getBeers().map(BeerResponse::toDomain)
    }

    suspend fun getBeerById(id: Int): Beer {
        return punkApi.getBeerById(id).toDomain()
    }

    suspend fun addBeer(beer: Beer) {
        punkApi.addBeer(beer.toRequest())
    }

    suspend fun updateBeer(id: Int, beer: Beer) {
        punkApi.updateBeer(id, beer.toRequest())
    }

    suspend fun deleteBeer(id: Int) {
        punkApi.deleteBeer(id)
    }
}