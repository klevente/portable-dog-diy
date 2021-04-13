package dev.klevente.portabledogdiy.domain

// default image: https://images.punkapi.com/v2/keg.png
class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String,
    val abv: Double,
    val ibu: Int,
    val targetFg: Int,
    val targetOg: Int,
    val volume: Volume,
    val boilVolume: Volume,
    val mash: List<Mash>,
    val fermentationTemperature: Temperature,
    val malts: List<Malt>,
    val hops: List<Hop>,
    val yeast: String,
)