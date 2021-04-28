package dev.klevente.portabledogdiy.ui.edit

import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import dev.klevente.portabledogdiy.ui.detail.DetailViewModel
import dev.klevente.portabledogdiy.ui.edit.EditPresenter.EditBeer
import java.io.IOException
import javax.inject.Inject

class EditViewModel @Inject constructor(
    private val editPresenter: EditPresenter,
) : RainbowCakeViewModel<EditViewState>(Loading) {

    object LoadFailedEvent : OneShotEvent
    object AddFailedEvent: OneShotEvent
    object UpdateFailedEvent: OneShotEvent

    fun loadBeer(id: Int) = execute {
        val beer = try {
            editPresenter.loadBeer(id)
        } catch (e: IOException) {
            postEvent(DetailViewModel.LoadFailedEvent)
            return@execute
        }

        viewState = EditReady(beer)
    }

    fun createNewBeer() {
        viewState = EditReady(editPresenter.createNewBeer())
    }

    fun addNewBeer(beer: EditBeer) = execute {
        try {
            editPresenter.addBeer(beer)
        } catch (e: Exception) {
            postEvent(AddFailedEvent)
        }
    }

    fun updateBeer(beer: EditBeer) = execute {
        try {
            editPresenter.updateBeer(beer)
        } catch (e: Exception) {
            postEvent(UpdateFailedEvent)
        }
    }
}