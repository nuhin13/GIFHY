package com.nuhin13.domain.feature.giphy_search.entity

data class GiphyItem(
    val type: String?,
    val id: String,
    val url: String?,
    val title: String?,
    val images: String?,
    val user: User?,
)

data class User(
    val username: String?,
    val profileImage: String?
)