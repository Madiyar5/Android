package com.example.lab22

import androidx.annotation.LongDef
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/celebrity")
    suspend fun searchCelebrities(
        @Query("name") name: String?,
        @Query("min_net_worth") minNetWorth: Double?,
        @Query("max_net_worth") maxNetWorth: Long?,
        @Query("nationality") nationality: String?,
        @Query("min_height") minHeight: Double?,
        @Query("max_height") maxHeight: Double?,
        @Query("X-Api-Key") apiKey: String
    ): List<Celebrity>
}
