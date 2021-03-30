package dev.klevente.portabledogdiy.ui.detail

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailPresenter: DetailPresenter,
) : RainbowCakeViewModel<DetailViewState>(Loading) {

}