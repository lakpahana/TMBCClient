package com.example.tmbcclient.data.repository.movie.datasource

import com.example.tmbcclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviestoDB(movies:List<Movie>)
    suspend fun clearMoviesFromDB()

}