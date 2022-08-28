package com.example.tmbcclient.domain.repository

import com.example.tmbcclient.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?

}