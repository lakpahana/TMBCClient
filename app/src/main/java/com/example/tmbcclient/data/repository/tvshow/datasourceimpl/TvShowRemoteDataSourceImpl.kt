package com.example.tmbcclient.data.repository.tvshow.datasourceimpl

import com.example.tmbcclient.data.api.TMDBService
import com.example.tmbcclient.data.model.tvshow.TvShowList
import com.example.tmbcclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)

}