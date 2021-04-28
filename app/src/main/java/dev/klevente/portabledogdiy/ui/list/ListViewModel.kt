package dev.klevente.portabledogdiy.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listPresenter: ListPresenter,
) : RainbowCakeViewModel<ListViewState>(Loading) {

    // Define business events here
    // object SampleEvent : OneShotEvent

    // Define UI event handlers here
    // fun doStuff() = execute { ... }

    init {
        execute { loadBeers() }
    }

    fun reload() {
        execute { loadBeers() }
    }

    private suspend fun loadBeers() {
        viewState = Loading
        viewState = try {
            val items = listPresenter.loadBeers()
            ListReady(items)
        } catch (e: IOException) {
            Error
        }
    }
}