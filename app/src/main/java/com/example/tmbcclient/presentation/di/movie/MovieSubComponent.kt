package com.example.tmbcclient.presentation.di.movie

import com.example.tmbcclient.presentation.artist.ArtistActivity
import com.example.tmbcclient.presentation.movie.MovieActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity: MovieActivity)
    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }
}