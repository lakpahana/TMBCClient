package com.example.tmbcclient.domain.repository

import com.example.tmbcclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies():List<Movie>?

    suspend fun updateMovies():List<Movie>?

}