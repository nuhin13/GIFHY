package com.nuhin13.data.di

import com.nuhin13.data.api.ApiService
import com.nuhin13.data.features.gifhy_search.GiphyRepositoryImpl
import com.nuhin13.data.features.gifhy_search.datasource.GiphyDataSource
import com.nuhin13.data.features.gifhy_search.datasource.GiphyHttpDataSourceImpl
import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideGiphyRepo(dataSource: GiphyDataSource): GiphyRepository {
        return GiphyRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideGiphyDataSource(apiService: ApiService): GiphyDataSource {
        return GiphyHttpDataSourceImpl(apiService)
    }
}