package dev.klevente.portabledogdiy.mock

import dev.klevente.portabledogdiy.data.disk.BeerDao
import dev.klevente.portabledogdiy.data.disk.entities.*


class MockBeerDao : BeerDao {

    override suspend fun getAllBeers() = listOf(beer1, beer2)

    override suspend fun getBeerById(id: Int) = beer1

    override suspend fun addBeer(vararg roomBeer: RoomBeer) {

    }

    override suspend fun deleteBeer(id: Int) {

    }

    companion object {
        val beer1 = RoomBeer(
            id = 1,
            name = "Test Beer 1",
            tagline = "Tagline 1",
            description = "Description 1",
            imageUrl = "https://images.punkapi.com/v2/192.png",
            abv = 5.5,
            ibu = 43.0,
            targetFg = 1034.0,
            targetOg = 1070.0,
            volume = RoomVolume(25.0, "litres"),
            boilVolume = RoomVolume(25.0, "litres"),
            mash = listOf(RoomMash(RoomTemperature(65.0, "celsius"), duration = 75)),
            fermentationTemperature = RoomTemperature(19.0, "celsius"),
            malts = listOf(RoomMalt("Extra Pale", RoomMass(5.3, "kilograms"))),
            hops = listOf(
                RoomHop("Ahtanum", RoomMass(17.5, "grams"), "start"),
                RoomHop("Chinook", RoomMass(15.0, "grams"), "start")
            ),
            yeast = "Wyeast 1056 - American Ale"
        )

        val beer2 = RoomBeer(
            id = 2,
            name = "Test Beer 2",
            tagline = "Tagline 2",
            description = "Description 2",
            imageUrl = "https://images.punkapi.com/v2/192.png",
            abv = 5.5,
            ibu = 43.0,
            targetFg = 1034.0,
            targetOg = 1070.0,
            volume = RoomVolume(25.0, "litres"),
            boilVolume = RoomVolume(25.0, "litres"),
            mash = listOf(RoomMash(RoomTemperature(65.0, "celsius"), duration = 75)),
            fermentationTemperature = RoomTemperature(19.0, "celsius"),
            malts = listOf(RoomMalt("Extra Pale", RoomMass(5.3, "kilograms"))),
            hops = listOf(
                RoomHop("Ahtanum", RoomMass(17.5, "grams"), "start"),
                RoomHop("Chinook", RoomMass(15.0, "grams"), "start")
            ),
            yeast = "Wyeast 1056 - American Ale"
        )
    }
}