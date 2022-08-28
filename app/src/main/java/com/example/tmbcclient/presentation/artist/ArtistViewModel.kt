package com.example.tmbcclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmbcclient.domain.usecase.GetArtistsUseCase
import com.example.tmbcclient.domain.usecase.GetMoviesUseCase
import com.example.tmbcclient.domain.usecase.UpdateArtistsUseCase
import com.example.tmbcclient.domain.usecase.UpdateMoviesUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData {
        val artistlist = getArtistsUseCase.execute()
        emit(artistlist)
    }
    fun updateArtists() = liveData {
        val artistlist = updateArtistsUseCase.execute()
        emit(artistlist)
    }

}