package com.example.tmbcclient.data.repository.tvshow.datasource

import com.example.tmbcclient.data.model.tvshow.TvShow


interface TvShowCacheDataSource {
 suspend fun getTvShowstoCache():List<TvShow>
 suspend fun saveTvShowstoCache(movies:List<TvShow>)
}