package dev.klevente.portabledogdiy.ui.detail

import dev.klevente.portabledogdiy.ui.detail.DetailPresenter.DetailedBeer

sealed class DetailViewState

object Loading : DetailViewState()

data class DetailReady(val beer: DetailedBeer) : DetailViewState()