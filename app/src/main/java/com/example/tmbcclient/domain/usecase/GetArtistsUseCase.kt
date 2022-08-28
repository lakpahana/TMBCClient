package com.example.tmbcclient.domain.usecase

import com.example.tmbcclient.data.model.artist.Artist
import com.example.tmbcclient.domain.repository.ArtistsRepository

class GetArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute() : List<Artist>?
    =artistsRepository.getArtists()
}