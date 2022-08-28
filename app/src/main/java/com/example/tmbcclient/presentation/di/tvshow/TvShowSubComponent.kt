package com.example.tmbcclient.presentation.di.tvshow

import com.example.tmbcclient.presentation.artist.ArtistActivity
import com.example.tmbcclient.presentation.tvshows.TvShowActivity
import dagger.Subcomponent


@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }
}