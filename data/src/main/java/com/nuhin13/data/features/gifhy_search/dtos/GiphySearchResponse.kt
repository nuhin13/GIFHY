package com.nuhin13.data.features.gifhy_search.dtos

data class GiphySearchResponse(
    val data: ArrayList<SearchDataResponse>,
    val meta: Meta,
    val pagination: Pagination
)

data class Meta(
    val status: String,
    val msg: String,
    val response_id: String
)

data class Pagination(
    val count: Int,
    val offset: Int,
    val total_count: Int
)