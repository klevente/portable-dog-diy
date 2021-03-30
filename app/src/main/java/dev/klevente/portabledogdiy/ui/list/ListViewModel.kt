package dev.klevente.portabledogdiy.ui.list

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val listPresenter: ListPresenter,
) : RainbowCakeViewModel<ListViewState>(Loading) {

    // Define business events here
    // object SampleEvent : OneShotEvent

    // Define UI event handlers here
    // fun doStuff() = execute { ... }
}