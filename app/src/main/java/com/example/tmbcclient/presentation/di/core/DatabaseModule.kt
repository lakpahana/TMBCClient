package com.example.tmbcclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmbcclient.data.db.ArtistDao
import com.example.tmbcclient.data.db.MovieDao
import com.example.tmbcclient.data.db.TMDBDatabase
import com.example.tmbcclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"tmdbClient")
            .build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun providesTvDao(tmdbDatabase: TMDBDatabase) : TvShowDao{
        return tmdbDatabase.tvDao()
    }
    @Singleton
    @Provides
    fun providesArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }
}