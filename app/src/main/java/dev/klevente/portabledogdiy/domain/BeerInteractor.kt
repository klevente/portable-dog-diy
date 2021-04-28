package dev.klevente.portabledogdiy.domain

import dev.klevente.portabledogdiy.data.disk.DiskDataSource
import dev.klevente.portabledogdiy.data.network.NetworkDataSource
import timber.log.Timber
import javax.inject.Inject

class BeerInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource,
) {
    suspend fun getBeers(): List<Beer> {
        try {
            val networkBeers = networkDataSource.getBeers()
            diskDataSource.addBeers(*networkBeers.toTypedArray())
        } catch (e: Exception) {
            Timber.w(e, "Failed to query beers from API")
        }

        return diskDataSource.getBeers()
    }

    suspend fun getBeerById(id: Int): Beer {
        try {
            val networkBeer = networkDataSource.getBeerById(id)
            diskDataSource.addBeers(networkBeer)
        } catch (e: Exception) {
            Timber.w(e, "Failed to query beer from API")
        }

        return diskDataSource.getBeerById(id) ?: throw IllegalArgumentException("Beer not found with ID=$id")
    }

    suspend fun addBeer(beer: Beer) {
        networkDataSource.addBeer(beer)
    }

    suspend fun updateBeer(beer: Beer) {
        networkDataSource.updateBeer(beer)
    }

    suspend fun deleteBeer(id: Int) {
        networkDataSource.deleteBeer(id)
    }
}