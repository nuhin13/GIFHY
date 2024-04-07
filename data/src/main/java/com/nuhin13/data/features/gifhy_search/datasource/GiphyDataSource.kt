package com.nuhin13.data.features.gifhy_search.datasource

import com.nuhin13.data.features.gifhy_search.dtos.GiphySearchResponse

interface GiphyDataSource {
    suspend fun getGiphyList(query: String?): GiphySearchResponse
}