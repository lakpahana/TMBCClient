package com.example.tmbcclient.presentation.di.movie

import com.example.tmbcclient.domain.usecase.GetArtistsUseCase
import com.example.tmbcclient.domain.usecase.GetMoviesUseCase
import com.example.tmbcclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmbcclient.domain.usecase.UpdateMoviesUseCase
import com.example.tmbcclient.presentation.artist.ArtistViewModel
import com.example.tmbcclient.presentation.artist.ArtistViewModelFactory
import com.example.tmbcclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }

}