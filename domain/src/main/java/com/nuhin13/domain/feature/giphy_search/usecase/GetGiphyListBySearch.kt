package com.nuhin13.domain.feature.giphy_search.usecase

import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import javax.inject.Inject

class GetGiphyListBySearch @Inject constructor(private val userRepo: GiphyRepository) {
    suspend fun getSearchGiphyList(query: String): GiphyList {
        return userRepo.searchGiphyList(query)
    }
}