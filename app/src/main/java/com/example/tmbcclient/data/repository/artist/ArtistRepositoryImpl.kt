package com.example.tmbcclient.data.repository.artist

import android.util.Log
import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmbcclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmbcclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmbcclient.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(
    private val artistremoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistsRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.saveArtiststoDB(newListOfArtists)
        artistCacheDataSource.saveArtiststoCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistremoteDataSource.getArtists()
            val body = response.body()
            if (body!=null){
                artistList = body.artists
            }
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }



    suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (exception:Exception){
            Log.i("MyTag",exception.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtiststoDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtiststoCache()
        }catch (exception : Exception){
            Log.i("MyTag",exception.message.toString())
        }

        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtiststoCache(artistList)
        }

        return artistList
    }
}