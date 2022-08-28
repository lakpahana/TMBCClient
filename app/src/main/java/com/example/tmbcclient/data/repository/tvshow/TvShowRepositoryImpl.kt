package com.example.tmbcclient.data.repository.tvshow

import android.util.Log
import com.example.tmbcclient.data.model.tvshow.TvShow
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.tmbcclient.domain.repository.TvShowRepository
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository{
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListofTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearTvShowsFromDB()
        tvShowLocalDataSource.saveTvShowstoDB(newListofTvShows)
        tvShowCacheDataSource.saveTvShowstoCache(newListofTvShows)
        return newListofTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var movieList : List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body!=null){
                movieList = body.tvShows
            }
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getTvShowsFromDB() :List<TvShow>{
        lateinit var movieList : List<TvShow>
        try {
           movieList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }

        if (movieList.size>0)
            {
                return movieList
            }else{
                movieList = getTvShowsFromAPI()
                tvShowLocalDataSource.saveTvShowstoDB(movieList)
        }
        return movieList
    }

    suspend fun getTvShowsFromCache() : List<TvShow>{
        lateinit var movieList : List<TvShow>
        try {
            movieList = tvShowCacheDataSource.getTvShowstoCache()
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }

        if (movieList.size>0)
        {
            return movieList
        }else{
            movieList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowstoCache(movieList)
        }
        return movieList
    }

}