package com.example.tmbcclient.data.repository.artist.datasourceimpl

import com.example.tmbcclient.data.db.ArtistDao
import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(
    private val artistDao: ArtistDao
    ) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtiststoDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearArtistsFromDB() {
        return artistDao.deleteAllArtist()
    }
}