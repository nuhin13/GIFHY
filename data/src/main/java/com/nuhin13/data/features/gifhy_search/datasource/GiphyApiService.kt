package com.nuhin13.data.features.gifhy_search.datasource

import com.nuhin13.data.features.gifhy_search.dtos.GiphySearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApiService {
    @GET("v1/gifs/search")
    suspend fun searchGiphyList(
        @Query("api_key") apiKey: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String,
        @Query("q") query: String
    ): Response<GiphySearchResponse>
}