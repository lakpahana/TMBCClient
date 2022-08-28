package com.example.tmbcclient.data.repository.tvshow.datasource

import com.example.tmbcclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB():List<TvShow>
    suspend fun saveTvShowstoDB(movies:List<TvShow>)
    suspend fun clearTvShowsFromDB()

}