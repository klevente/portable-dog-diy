/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Punk API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dev.klevente.portabledogdiy.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property name
 * @property tagline
 * @property description
 * @property imageUrl
 * @property abv
 * @property ibu
 * @property targetFg
 * @property targetOg
 * @property volume
 * @property boilVolume
 * @property method
 * @property ingredients
 */
@JsonClass(generateAdapter = true)
data class BeerAddRequest(
    @Json(name = "name") @field:Json(name = "name") var name: String,
    @Json(name = "tagline") @field:Json(name = "tagline") var tagline: String,
    @Json(name = "description") @field:Json(name = "description") var description: String,
    @Json(name = "image_url") @field:Json(name = "image_url") var imageUrl: String,
    @Json(name = "abv") @field:Json(name = "abv") var abv: Double,
    @Json(name = "ibu") @field:Json(name = "ibu") var ibu: Double,
    @Json(name = "target_fg") @field:Json(name = "target_fg") var targetFg: Double,
    @Json(name = "target_og") @field:Json(name = "target_og") var targetOg: Double,
    @Json(name = "volume") @field:Json(name = "volume") var volume: Volume,
    @Json(name = "boil_volume") @field:Json(name = "boil_volume") var boilVolume: Volume,
    @Json(name = "method") @field:Json(name = "method") var method: Method,
    @Json(name = "ingredients") @field:Json(name = "ingredients") var ingredients: Ingredients
)
