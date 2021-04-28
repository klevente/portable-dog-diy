package dev.klevente.portabledogdiy.ui.detail

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import java.io.IOException
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailPresenter: DetailPresenter,
) : RainbowCakeViewModel<DetailViewState>(Loading) {

    object LoadFailedEvent : OneShotEvent
    object DeleteFailedEvent : OneShotEvent

    fun loadBeer(id: Int) = execute {
        val beer = try {
            detailPresenter.loadBeer(id)
        } catch (e: IOException) {
            postEvent(LoadFailedEvent)
            return@execute
        }

        viewState = DetailReady(beer)
    }

    fun deleteBeer(id: Int) = execute {
        try {
            detailPresenter.deleteBeer(id)
        } catch (e: Exception) {
            postEvent(DeleteFailedEvent)
        }
    }
}