package com.example.tmbcclient.data.repository.artist.datasource

import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.data.model.movie.Movie

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtiststoDB(artists:List<Artist>)
    suspend fun clearArtistsFromDB()
}