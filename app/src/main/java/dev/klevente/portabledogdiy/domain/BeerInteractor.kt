package dev.klevente.portabledogdiy.domain

import dev.klevente.portabledogdiy.data.disk.DiskDataSource
import dev.klevente.portabledogdiy.data.network.NetworkDataSource
import javax.inject.Inject

class BeerInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource,
) {

}