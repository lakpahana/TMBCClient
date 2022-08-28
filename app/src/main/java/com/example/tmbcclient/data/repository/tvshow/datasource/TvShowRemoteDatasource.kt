package com.example.tmbcclient.data.repository.tvshow.datasource

import com.example.tmbcclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows():Response<TvShowList>
}