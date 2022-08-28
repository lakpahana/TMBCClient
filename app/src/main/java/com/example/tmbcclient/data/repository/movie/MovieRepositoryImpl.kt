package com.example.tmbcclient.data.repository.movie

import android.util.Log
import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmbcclient.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmbcclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.tmbcclient.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository{
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListofMovies = getMoviesFromAPI()
        movieLocalDataSource.clearMoviesFromDB()
        movieLocalDataSource.saveMoviestoDB(newListofMovies)
        movieCacheDataSource.saveMoviestoCache(newListofMovies)
        return newListofMovies
    }

    suspend fun getMoviesFromAPI():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() :List<Movie>{
        lateinit var movieList : List<Movie>
        try {
           movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }

        if (movieList.size>0)
            {
                return movieList
            }else{
                movieList = getMoviesFromAPI()
                movieLocalDataSource.saveMoviestoDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviestoCache()
        }catch (exception:Exception){
            Log.i("Mytag", exception.message.toString())
        }

        if (movieList.size>0)
        {
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviestoCache(movieList)
        }
        return movieList
    }

}