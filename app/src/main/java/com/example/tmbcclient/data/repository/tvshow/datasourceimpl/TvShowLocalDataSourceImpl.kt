package com.example.tmbcclient.data.repository.tvshow.datasourceimpl

import com.example.tmbcclient.data.db.TvShowDao
import com.example.tmbcclient.data.model.tvshow.TvShow
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvshowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvshowDao.getTvShows()
    }

    override suspend fun saveTvShowstoDB(movies: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.saveTvShows(movies)
        }
    }

    override suspend fun clearTvShowsFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            tvshowDao.deleteAllTvShows()
        }
    }
}