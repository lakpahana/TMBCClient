package com.example.tmbcclient.presentation.di.artist

import com.example.tmbcclient.presentation.artist.ArtistActivity
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistActivity: ArtistActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create() : ArtistSubComponent
    }
}