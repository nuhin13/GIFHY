package com.nuhin13.domain.feature.giphy_search.repository

import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface GiphyRepository {
    suspend fun searchGiphyList(query: String, limit:Int): Flow<DataResult<GiphyList>>
}