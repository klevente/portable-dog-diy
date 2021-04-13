/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Punk API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dev.klevente.portabledogdiy.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property name
 * @property amount
 * @property add
 */
@JsonClass(generateAdapter = true)
data class Hop(
    @Json(name = "name") @field:Json(name = "name") var name: String,
    @Json(name = "amount") @field:Json(name = "amount") var amount: Mass,
    @Json(name = "add") @field:Json(name = "add") var add: String
)
