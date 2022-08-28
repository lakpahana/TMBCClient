package com.example.tmbcclient.presentation.di.core

import com.example.tmbcclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmbcclient.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmbcclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbcclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbcclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providesMovieCacheDataSource() : MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowCacheDataSource() : TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }


}