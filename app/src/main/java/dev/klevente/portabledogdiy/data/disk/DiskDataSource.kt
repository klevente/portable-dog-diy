package dev.klevente.portabledogdiy.data.disk

import dev.klevente.portabledogdiy.data.disk.entities.RoomBeer
import dev.klevente.portabledogdiy.domain.Beer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
    private val beerDao: BeerDao,
) {
    suspend fun getBeers() = beerDao.getAllBeers().map(RoomBeer::toBeer)

    suspend fun getBeerById(id: Int) = beerDao.getBeerById(id)?.let(RoomBeer::toBeer)

    suspend fun addBeers(vararg beer: Beer) = beerDao.addBeer(*beer.map(Beer::toRoomBeer).toTypedArray())

    suspend fun updateBeer(beer: Beer) = beerDao.addBeer(beer.toRoomBeer())

    suspend fun deleteBeer(id: Int) = beerDao.deleteBeer(id)
}