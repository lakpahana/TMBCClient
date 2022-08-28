package com.example.tmbcclient.data.repository.artist.datasourceimpl

import com.example.tmbcclient.data.api.TMDBService
import com.example.tmbcclient.data.model.artist.ArtistList
import com.example.tmbcclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList>
    = tmdbService.getPopularArtists(apiKey)

}