/**
 * NOTE: This class is auto generated by the Swagger Gradle Codegen for the following API: Punk API
 *
 * More info on this tool is available on https://github.com/Yelp/swagger-gradle-codegen
 *
 */

package dev.klevente.portabledogdiy.data.network

import dev.klevente.portabledogdiy.data.network.models.BeerAddRequest
import dev.klevente.portabledogdiy.data.network.models.BeersResponse
import retrofit2.http.*

@JvmSuppressWildcards
interface PunkApi {
    /**
     * Add a new beer
     * The endpoint is owned by portabledogdiy service owner
     * @param beer (required)
     */
    @Headers(
        "X-Operation-ID: addBeer",
        "Content-Type: application/json"
    )
    @POST("beers")
    suspend fun addBeer(
        @retrofit2.http.Body beer: BeerAddRequest
    )
    /**
     * Delete beer with specified ID
     * The endpoint is owned by portabledogdiy service owner
     * @param id (required)
     */
    @Headers(
        "X-Operation-ID: deleteBeer",
        "Content-Type: application/json"
    )
    @DELETE("beers/{id}")
    suspend fun deleteBeer(
        @retrofit2.http.Path("id") id: Int
    )
    /**
     * Get beer with specified ID
     * The endpoint is owned by portabledogdiy service owner
     * @param id (required)
     */
    @Headers(
        "X-Operation-ID: getBeerById",
        "Content-Type: application/json"
    )
    @GET("beers/{id}")
    suspend fun getBeerById(
        @retrofit2.http.Path("id") id: Int
    ): BeersResponse
    /**
     * Get all beers
     * The endpoint is owned by portabledogdiy service owner
     */
    @Headers(
        "X-Operation-ID: getBeers",
        "Content-Type: application/json"
    )
    @GET("beers")
    suspend fun getBeers(): BeersResponse
    /**
     * Update beer with specified ID
     * The endpoint is owned by portabledogdiy service owner
     * @param id (required)
     * @param beer (required)
     */
    @Headers(
        "X-Operation-ID: updateBeer",
        "Content-Type: application/json"
    )
    @PUT("beers/{id}")
    suspend fun updateBeer(
        @retrofit2.http.Path("id") id: Int,
        @retrofit2.http.Body beer: BeerAddRequest
    )
}