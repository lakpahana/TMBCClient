package com.example.tmbcclient.domain.usecase

import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.domain.repository.MovieRepository

class UpdateMoviesUseCase (private val movieRepository: MovieRepository){
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}