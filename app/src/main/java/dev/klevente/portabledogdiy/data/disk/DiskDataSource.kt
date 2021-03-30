package dev.klevente.portabledogdiy.data.disk

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
    private val beerDao: BeerDao,
) {

    suspend fun getBeers() {
        TODO("Not yet implemented")
    }

    suspend fun getBeerById() {
        TODO("Not yet implemented")
    }

    suspend fun addBeer() {
        TODO("Not yet implemented")
    }

    suspend fun updateBeer() {
        TODO("Not yet implemented")
    }

    suspend fun deleteBeer() {
        TODO("Not yet implemented")
    }
}