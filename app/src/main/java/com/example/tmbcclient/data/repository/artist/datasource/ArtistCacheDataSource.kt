package com.example.tmbcclient.data.repository.artist.datasource

import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtiststoCache():List<Artist>
    suspend fun saveArtiststoCache(movies:List<Artist>)
}