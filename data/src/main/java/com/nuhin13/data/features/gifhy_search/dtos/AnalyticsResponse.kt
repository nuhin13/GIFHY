package com.nuhin13.data.features.gifhy_search.dtos

data class Analytics(
    val onclick: AnalyticsInfoObject,
    val onload: AnalyticsInfoObject,
    val onsent: AnalyticsInfoObject
)

data class AnalyticsInfoObject(
    val url: String
)