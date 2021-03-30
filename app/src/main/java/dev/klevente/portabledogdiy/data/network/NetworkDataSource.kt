package dev.klevente.portabledogdiy.data.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val punkApi: PunkApi,
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

    suspend fun deleteBeer(id: String) {
        TODO("Not yet implemented")
    }
}