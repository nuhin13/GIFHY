package com.nuhin13.data.features.gifhy_search

import com.nuhin13.data.features.gifhy_search.datasource.GiphyDataSource
import com.nuhin13.domain.feature.giphy_search.entity.GiphyItem
import com.nuhin13.domain.feature.giphy_search.entity.GiphyList
import com.nuhin13.domain.feature.giphy_search.entity.User
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import com.nuhin13.domain.util.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(private val giphyDataSource: GiphyDataSource) :
    GiphyRepository {

    override suspend fun searchGiphyList(query: String, limit: Int): Flow<DataResult<GiphyList>> {

        val giphyItemList: ArrayList<GiphyItem> = arrayListOf()

        return giphyDataSource.getGiphyList(query, limit).map { apiResponse ->
            when (apiResponse) {
                is DataResult.Success -> {
                    if (apiResponse.data!!.data.isEmpty()) {
                        DataResult.Error("No data found")
                    } else {
                        for (data in apiResponse.data!!.data) {
                            val giphyItem = GiphyItem(
                                id = data.id, title = data.title,
                                type = data.type, images = data.images.downsized_medium.url, url = data.url,
                                user = data.user?.let {
                                    User(
                                        username = it.username ?: "",
                                        profileImage = it.avatar_url ?: ""
                                    )
                                }
                            )

                            giphyItemList.add(giphyItem)
                        }

                        DataResult.Success(GiphyList(giphyItemList))
                    }
                }

                is DataResult.Error -> {
                    DataResult.Error("No data found")
                }

                is DataResult.Loading -> {
                    DataResult.Loading(null, true)
                }

                else -> {
                    DataResult.Error("Something went wrong")
                }
            }
        }
    }
}