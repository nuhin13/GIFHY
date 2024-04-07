package com.nuhin13.domain.di

import com.nuhin13.domain.feature.giphy_search.repository.GiphyRepository
import com.nuhin13.domain.feature.giphy_search.usecase.GetGiphyListBySearch
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideUserDetailsCase(userRepo: GiphyRepository): GetGiphyListBySearch {
        return GetGiphyListBySearch(userRepo)
    }
}