/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Punk API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 */

package dev.klevente.portabledogdiy.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @property value
 * @property unit
 */
@JsonClass(generateAdapter = true)
data class Volume(
    @Json(name = "value") @field:Json(name = "value") var value: Double,
    @Json(name = "unit") @field:Json(name = "unit") var unit: String
)
