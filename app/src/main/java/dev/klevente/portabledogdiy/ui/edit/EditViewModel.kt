package dev.klevente.portabledogdiy.ui.edit

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class EditViewModel @Inject constructor(
    private val editPresenter: EditPresenter,
) : RainbowCakeViewModel<EditViewState>(Loading) {
}