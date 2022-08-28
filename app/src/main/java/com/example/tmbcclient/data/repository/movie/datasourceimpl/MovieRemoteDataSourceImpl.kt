package com.example.tmbcclient.data.repository.movie.datasourceimpl

import com.example.tmbcclient.data.api.TMDBService
import com.example.tmbcclient.data.model.movie.MovieList
import com.example.tmbcclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
    ) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}