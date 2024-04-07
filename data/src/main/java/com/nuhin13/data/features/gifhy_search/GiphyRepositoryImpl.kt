package com.nuhin13.data.features.gifhy_search

import com.nuhin13.data.features.gifhy_search.datasource.GiphyDataSource
import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val giphyDataSource: GiphyDataSource
) : GiphyRepository {

    override suspend fun searchGiphyList(query: String): GiphyList {

        val response = giphyDataSource.getGiphyList(query)

        val giphyList = GiphyList(arrayListOf())

        return giphyList
    }
}