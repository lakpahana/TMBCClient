package com.example.tmbcclient.data.db

import androidx.room.*
import com.example.tmbcclient.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies:List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies() : List<Movie>

}