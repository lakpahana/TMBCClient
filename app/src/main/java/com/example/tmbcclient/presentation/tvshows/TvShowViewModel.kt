package com.example.tmbcclient.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmbcclient.domain.usecase.GetTvShowsUseCase
import com.example.tmbcclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase
    ,private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {
    fun gettvshows() = liveData {
        val tvshowlist = getTvShowsUseCase.execute()
        emit(tvshowlist)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}