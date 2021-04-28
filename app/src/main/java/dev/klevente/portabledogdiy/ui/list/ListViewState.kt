package dev.klevente.portabledogdiy.ui.list

import dev.klevente.portabledogdiy.ui.list.ListPresenter.BeerItem

sealed class ListViewState

object Loading : ListViewState()

data class ListReady(val beers: List<BeerItem>) : ListViewState()

object Error : ListViewState()