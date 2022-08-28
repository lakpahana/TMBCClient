package com.example.tmbcclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmbcclient.data.model.movie.Movie
import com.example.tmbcclient.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows: List<TvShow>)

    @Query("DELETE FROM popular_tvshow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_artists")
    suspend fun getTvShows() : List<TvShow>

}