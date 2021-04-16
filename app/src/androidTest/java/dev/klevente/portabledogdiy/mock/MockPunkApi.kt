package dev.klevente.portabledogdiy.mock

import dev.klevente.portabledogdiy.data.network.PunkApi
import dev.klevente.portabledogdiy.data.network.models.*

class MockPunkApi : PunkApi {

    override suspend fun addBeer(beer: BeerAddRequest) {

    }

    override suspend fun deleteBeer(id: Int) {

    }

    override suspend fun getBeerById(id: Int) = beer1

    override suspend fun getBeers() = listOf(beer1, beer2)

    override suspend fun updateBeer(id: Int, beer: BeerAddRequest) {

    }

    private val beer1 = BeerResponse(
        id = 1,
        name = "Test Beer 1",
        tagline = "Tagline 1",
        description = "Description 1",
        imageUrl = "https://images.punkapi.com/v2/192.png",
        abv = 5.5,
        ibu = 43,
        targetFg = 1034,
        targetOg = 1070,
        volume = Volume(25.0, "liters"),
        boilVolume = Volume(25.0, "liters"),
        method = Method(
            mashTemp = listOf(Mash(temp = Temperature(65.0, "celsius"), duration = 75)),
            fermentation = Fermentation(Temperature(19.0, "celsius"))
        ),
        ingredients = Ingredients(
            malt = listOf(Malt("Extra Pale", Mass(5.3, "kilograms"))),
            hops = listOf(Hop("Ahtanum", Mass(17.5, "grams"), "start"), Hop("Chinook", Mass(15.0, "grams"), "start")),
            yeast = "Wyeast 1056 - American Ale"
        )
    )

    private val beer2 = BeerResponse(
        id = 2,
        name = "Test Beer 2",
        tagline = "Tagline 2",
        description = "Description 2",
        imageUrl = "https://images.punkapi.com/v2/192.png",
        abv = 5.5,
        ibu = 43,
        targetFg = 1034,
        targetOg = 1070,
        volume = Volume(25.0, "liters"),
        boilVolume = Volume(25.0, "liters"),
        method = Method(
            mashTemp = listOf(Mash(temp = Temperature(65.0, "celsius"), duration = 75)),
            fermentation = Fermentation(Temperature(19.0, "celsius"))
        ),
        ingredients = Ingredients(
            malt = listOf(Malt("Extra Pale", Mass(5.3, "kilograms"))),
            hops = listOf(Hop("Ahtanum", Mass(17.5, "grams"), "start"), Hop("Chinook", Mass(15.0, "grams"), "start")),
            yeast = "Wyeast 1056 - American Ale"
        )
    )
}