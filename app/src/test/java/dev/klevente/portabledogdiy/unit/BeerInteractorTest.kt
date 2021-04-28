package dev.klevente.portabledogdiy.unit

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import dev.klevente.portabledogdiy.data.disk.DiskDataSource
import dev.klevente.portabledogdiy.data.disk.toBeer
import dev.klevente.portabledogdiy.data.network.NetworkDataSource
import dev.klevente.portabledogdiy.data.network.toDomain
import dev.klevente.portabledogdiy.domain.BeerInteractor
import dev.klevente.portabledogdiy.mock.MockBeerDao
import dev.klevente.portabledogdiy.mock.MockPunkApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BeerInteractorTest {

    private lateinit var beerInteractor: BeerInteractor

    private val networkDataSource = mock<NetworkDataSource>()
    private val diskDataSource = mock<DiskDataSource>()

    @Before
    fun setup() {
        beerInteractor = BeerInteractor(networkDataSource, diskDataSource)
    }

    @Test
    fun `get beers calls the network and disk data sources`() = runBlocking {
        val networkBeer1 = MockPunkApi.beer1.toDomain()
        val networkBeer2 = MockPunkApi.beer2.toDomain()
        val diskBeer1 = MockBeerDao.beer1.toBeer()
        val diskBeer2 = MockBeerDao.beer2.toBeer()
        whenever(networkDataSource.getBeers()).doReturn(listOf(networkBeer1, networkBeer2))
        whenever(diskDataSource.getBeers()).doReturn(listOf(diskBeer1, diskBeer2))

        val beers = beerInteractor.getBeers()

        verify(diskDataSource).addBeers(networkBeer1, networkBeer2)

        assert(beers.size == 2)
    }

    @Test
    fun `get beer calls the network and disk data sources`() = runBlocking {
        val id = 1
        val networkBeer = MockPunkApi.beer1.toDomain()
        val diskBeer = MockBeerDao.beer1.toBeer()
        whenever(networkDataSource.getBeerById(id)).doReturn(networkBeer)
        whenever(diskDataSource.getBeerById(id)).doReturn(diskBeer)

        val beer = beerInteractor.getBeerById(id)

        verify(diskDataSource).addBeers(networkBeer)

        assert(beer == networkBeer)
    }

    @Test
    fun `add beer calls the network data source`() = runBlocking {
        val beer = MockPunkApi.beer1.toDomain()
        beerInteractor.addBeer(beer)

        verify(networkDataSource).addBeer(beer)
    }

    @Test
    fun `update beer calls the network data source`() = runBlocking {
        val beer = MockPunkApi.beer1.toDomain()
        beerInteractor.updateBeer(beer)

        verify(networkDataSource).updateBeer(beer)
    }

    @Test
    fun `delete beer calls the network data source`() = runBlocking {
        val id = 1
        beerInteractor.deleteBeer(id)

        verify(networkDataSource).deleteBeer(id)
    }
}