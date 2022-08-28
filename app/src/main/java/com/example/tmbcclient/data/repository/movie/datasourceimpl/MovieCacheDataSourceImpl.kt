package com.example.tmbcclient.data.repository.movie.datasourceimpl

import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviestoCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviestoCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}