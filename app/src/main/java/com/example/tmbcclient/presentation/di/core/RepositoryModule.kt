package com.example.tmbcclient.presentation.di.core

import com.example.tmbcclient.data.repository.artist.ArtistRepositoryImpl
import com.example.tmbcclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmbcclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmbcclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmbcclient.data.repository.movie.MovieRepositoryImpl
import com.example.tmbcclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbcclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbcclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmbcclient.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmbcclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import com.example.tmbcclient.domain.repository.ArtistsRepository
import com.example.tmbcclient.domain.repository.MovieRepository
import com.example.tmbcclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistsRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )


    }
}