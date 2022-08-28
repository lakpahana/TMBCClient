package com.example.tmbcclient.data.repository.movie.datasource

import com.example.tmbcclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies():Response<MovieList>
}