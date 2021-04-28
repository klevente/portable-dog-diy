package dev.klevente.portabledogdiy.unit

import dev.klevente.portabledogdiy.di.DaggerAppTestComponent
import kotlinx.coroutines.runBlocking
import org.junit.Test

class DetailPresenterTest {

    private val detailPresenter = DaggerAppTestComponent.create().detailPresenter()

    @Test
    fun `edit presenter can load a beer by id`() = runBlocking {
        val beer = detailPresenter.loadBeer(1)
        assert(beer.id == 1)
    }

    @Test
    fun `edit presenter can delete a beer successfully`() = runBlocking {
        detailPresenter.deleteBeer(1)
        // no exception means success
    }
}