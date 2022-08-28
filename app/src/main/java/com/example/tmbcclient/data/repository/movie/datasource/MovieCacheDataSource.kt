package com.example.tmbcclient.data.repository.movie.datasource

import com.example.tmbcclient.data.model.movie.Movie

interface MovieCacheDataSource {
 suspend fun getMoviestoCache():List<Movie>
 suspend fun saveMoviestoCache(movies:List<Movie>)
}