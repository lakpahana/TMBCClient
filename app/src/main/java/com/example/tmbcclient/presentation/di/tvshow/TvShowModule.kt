package com.example.tmbcclient.presentation.di.tvshow

import com.example.tmbcclient.domain.usecase.GetArtistsUseCase
import com.example.tmbcclient.domain.usecase.GetTvShowsUseCase
import com.example.tmbcclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmbcclient.domain.usecase.UpdateTvShowsUseCase
import com.example.tmbcclient.presentation.artist.ArtistViewModel
import com.example.tmbcclient.presentation.artist.ArtistViewModelFactory
import com.example.tmbcclient.presentation.tvshows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}