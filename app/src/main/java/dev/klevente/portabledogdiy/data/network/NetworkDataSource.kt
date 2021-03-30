package dev.klevente.portabledogdiy.data.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val punkApi: PunkApi,
) {
}