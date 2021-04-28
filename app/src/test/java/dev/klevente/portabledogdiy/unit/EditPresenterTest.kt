package dev.klevente.portabledogdiy.unit

import dev.klevente.portabledogdiy.di.DaggerAppTestComponent
import kotlinx.coroutines.runBlocking
import org.junit.Test

class EditPresenterTest {

    private val editPresenter = DaggerAppTestComponent.create().editPresenter()

    @Test
    fun `edit presenter can successfully load a beer`() = runBlocking {
        val beer = editPresenter.loadBeer(1)
        assert(beer.id == 1)
    }

    @Test
    fun `edit presenter can create beer with default values`() {
        val beer = editPresenter.createNewBeer()
        assert(beer.id == -1)
        // this makes sure correct default data is there
        assert(beer.og.toDouble() == 1000.0)
        assert(beer.fg.toDouble() == 1000.0)
        assert(beer.malts.isEmpty())
        assert(beer.hops.isEmpty())
        assert(beer.mash.isEmpty())
    }

    @Test
    fun `edit presenter can add a new beer`() = runBlocking {
        val newBeer = editPresenter.createNewBeer()
        newBeer.description = "description"
        editPresenter.addBeer(newBeer)
        // no exception means success
    }

    @Test
    fun `edit presenter can update a beer`() = runBlocking {
        val beer = editPresenter.loadBeer(1)
        beer.description = "new description"
        editPresenter.updateBeer(beer)
        // no exception means success
    }
}