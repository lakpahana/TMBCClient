package com.example.tmbcclient.presentation.di.core

import com.example.tmbcclient.data.db.ArtistDao
import com.example.tmbcclient.data.db.MovieDao
import com.example.tmbcclient.data.db.TvShowDao
import com.example.tmbcclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmbcclient.data.repository.artist.datasourceimpl.ArtistLocalDataSourceImpl
import com.example.tmbcclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmbcclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbcclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbcclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMovieLocalDataSource( movieDao: MovieDao ) : MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }
    @Singleton
    @Provides
    fun providesTvLocalDataSource(tvShowDao: TvShowDao ) : TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
    @Singleton
    @Provides
    fun providesArtistLocalDataSource( artistDao: ArtistDao ) : ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}