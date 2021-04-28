package dev.klevente.portabledogdiy.ui.edit

import dev.klevente.portabledogdiy.ui.edit.EditPresenter.EditBeer

sealed class EditViewState

object Loading : EditViewState()

data class EditReady(val beer: EditBeer) : EditViewState()