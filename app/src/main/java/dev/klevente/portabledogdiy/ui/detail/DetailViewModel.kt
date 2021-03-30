package dev.klevente.portabledogdiy.ui.detail

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailPresenter: DetailPresenter,
) : RainbowCakeViewModel<DetailViewState>(Loading) {

    // Define business events here
    // object SampleEvent : OneShotEvent

    // Define UI event handlers here
    // fun doStuff() = execute { ... }
}