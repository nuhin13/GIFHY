package com.nuhin13.data.features.gifhy_search.datasource

import com.nuhin13.data.features.gifhy_search.dtos.GiphySearchResponse
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface GiphyDataSource {
    suspend fun getGiphyList(query: String, limit:Int): Flow<DataResult<GiphySearchResponse>?>
}