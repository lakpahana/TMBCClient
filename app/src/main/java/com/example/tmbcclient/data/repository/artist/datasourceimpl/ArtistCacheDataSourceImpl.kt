package com.example.tmbcclient.data.repository.artist.datasourceimpl

import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var movieList = ArrayList<Artist>()
    //lazy to rename movieliost
    //but did it
    override suspend fun getArtiststoCache(): List<Artist> {
        return movieList

    }

    override suspend fun saveArtiststoCache(movies: List<Artist>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}