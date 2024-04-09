package com.nuhin13.data.features.gifhy_search

import com.nuhin13.data.features.gifhy_search.datasource.GiphyDataSource
import com.nuhin13.domain.feature.giphy_search.entity.GiphyItem
import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import javax.inject.Inject
import kotlin.reflect.typeOf

class GiphyRepositoryImpl @Inject constructor(
    private val giphyDataSource: GiphyDataSource
) : GiphyRepository {

    override suspend fun searchGiphyList(query: String, limit:Int): GiphyList {
        val response = giphyDataSource.getGiphyList(query, limit)

        val giphyList: GiphyList
        val giphyItemList: ArrayList<GiphyItem> = arrayListOf()

        for (data in response.data) {
            val giphyItem = GiphyItem(
                id = data.id,
                title = data.title,
                type = data.type,
                images = data.images.preview_gif.url,
                url = data.url
            )

            giphyItemList.add(giphyItem)
        }

        giphyList = GiphyList(giphyItemList)

        return giphyList
    }
}