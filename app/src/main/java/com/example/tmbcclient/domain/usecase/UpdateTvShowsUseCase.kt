package com.example.tmbcclient.domain.usecase

import com.example.tmbcclient.data.model.tvshow.TvShow
import com.example.tmbcclient.domain.repository.TvShowRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>? =
        tvShowRepository.updateTvShows()
}