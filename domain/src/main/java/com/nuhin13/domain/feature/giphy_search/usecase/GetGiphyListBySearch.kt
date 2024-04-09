package com.nuhin13.domain.feature.giphy_search.usecase

import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetGiphyListBySearch @Inject constructor(private val giphyRepo: GiphyRepository) {
    suspend fun getSearchGiphyList(query: String, limit:Int): Flow<DataResult<GiphyList>> {
        return giphyRepo.searchGiphyList(query, limit)
    }
}