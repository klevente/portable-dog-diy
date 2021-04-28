package dev.klevente.portabledogdiy.unit

import dev.klevente.portabledogdiy.di.DaggerAppTestComponent
import dev.klevente.portabledogdiy.ui.list.ListPresenter
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ListPresenterTest {

    private val listPresenter: ListPresenter = DaggerAppTestComponent.create().listPresenter()

    @Test
    fun `list presenter can load beers correctly`() = runBlocking {
        val beers = listPresenter.loadBeers()

        assert(beers.size == 2)
    }
}