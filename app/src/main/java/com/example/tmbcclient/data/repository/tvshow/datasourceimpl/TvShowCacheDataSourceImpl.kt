package com.example.tmbcclient.data.repository.tvshow.datasourceimpl

import com.example.tmbcclient.data.model.tvshow.TvShow
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var movieList = ArrayList<TvShow>()
    override suspend fun getTvShowstoCache(): List<TvShow> {
        return movieList
    }

    override suspend fun saveTvShowstoCache(movies: List<TvShow>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}