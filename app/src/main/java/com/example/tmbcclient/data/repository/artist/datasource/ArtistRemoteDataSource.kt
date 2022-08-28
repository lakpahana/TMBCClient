package com.example.tmbcclient.data.repository.artist.datasource

import com.example.tmbcclient.data.model.artist.ArtistList
import com.example.tmbcclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>

}