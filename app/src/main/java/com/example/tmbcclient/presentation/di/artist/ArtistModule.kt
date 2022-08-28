package com.example.tmbcclient.presentation.di.artist

import com.example.tmbcclient.domain.usecase.GetArtistsUseCase
import com.example.tmbcclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmbcclient.presentation.artist.ArtistViewModel
import com.example.tmbcclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun providesArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }

}