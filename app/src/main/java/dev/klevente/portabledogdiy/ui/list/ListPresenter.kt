package dev.klevente.portabledogdiy.ui.list

import dev.klevente.portabledogdiy.domain.BeerInteractor
import javax.inject.Inject

class ListPresenter @Inject constructor(
        private val beerInteractor: BeerInteractor,
) {
}