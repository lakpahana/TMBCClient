package com.example.tmbcclient.presentation.di.core

import com.example.tmbcclient.data.api.TMDBService
import com.example.tmbcclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmbcclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmbcclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmbcclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmbcclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule (private val apiKey:String) {
    @Singleton
    @Provides
    fun providesMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun providesTvRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDatasource{
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }
    @Singleton
    @Provides
    fun providesArtsitRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }
}