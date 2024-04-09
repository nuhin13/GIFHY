package com.nuhin13.data.features.gifhy_search.datasource

import com.nuhin13.data.api.ApiConstants
import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.gifhy_search.dtos.GiphySearchResponse
import com.nuhin13.data.util.toResultFlow
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GiphyHttpDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    GiphyDataSource {
    override suspend fun getGiphyList(
        query: String,
        limit: Int
    ): Flow<DataResult<GiphySearchResponse>?> {
        return toResultFlow {
            apiService.searchGiphyList(
                ApiConstants.API_KEY,
                limit,
                0,
                "g",
                "en",
                query
            )
        }
    }
}