package com.nuhin13.domain.feature.giphy_search.usecase

import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import javax.inject.Inject

class GetGiphyListBySearch @Inject constructor(private val giphyRepo: GiphyRepository) {
    suspend fun getSearchGiphyList(query: String, limit:Int): GiphyList {
        return giphyRepo.searchGiphyList(query, limit)
    }
}