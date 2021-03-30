package dev.klevente.portabledogdiy.data.disk

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
        private val beerDao: BeerDao,
) {
}