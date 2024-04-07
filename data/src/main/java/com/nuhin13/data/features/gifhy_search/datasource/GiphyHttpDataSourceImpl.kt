package com.nuhin13.data.features.gifhy_search.datasource

import com.nuhin13.data.api.ApiConstants
import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.gifhy_search.dtos.GiphySearchResponse
import javax.inject.Inject

class GiphyHttpDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    GiphyDataSource {

    override suspend fun getGiphyList(query: String?): GiphySearchResponse {
        return apiService.searchGiphyList(
            ApiConstants.API_KEY,
            10,
            0,
            "g",
            "en",
            query ?: ""
        )
    }
}