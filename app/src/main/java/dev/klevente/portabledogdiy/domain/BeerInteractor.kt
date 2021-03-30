package dev.klevente.portabledogdiy.domain

import dev.klevente.portabledogdiy.data.disk.DiskDataSource
import dev.klevente.portabledogdiy.data.network.NetworkDataSource
import javax.inject.Inject

class BeerInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource,
) {
    suspend fun getBeers() {
        TODO("Not yet implemented")
    }

    suspend fun getBeerById(id: String) {
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