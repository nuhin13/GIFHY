package com.nuhin13.domain.feature.giphy_search.repository

import com.nuhin13.domain.feature.giphy_search.entity.GiphyList

interface GiphyRepository {
    suspend fun searchGiphyList(query: String): GiphyList
}