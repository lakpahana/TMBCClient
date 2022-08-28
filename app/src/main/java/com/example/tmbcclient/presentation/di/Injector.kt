package com.example.tmbcclient.presentation.di

import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.presentation.di.artist.ArtistSubComponent
import com.example.tmbcclient.presentation.di.movie.MovieSubComponent
import com.example.tmbcclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent
}