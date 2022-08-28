package com.example.tmbcclient.data.api

import com.example.tmbcclient.data.model.artist.ArtistList
import com.example.tmbcclient.data.model.movie.MovieList
import com.example.tmbcclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey:String):Response<MovieList>
    @GET("movie/tv")
    suspend fun getPopularTvShows(@Query("api_key")apiKey:String):Response<TvShowList>
    @GET("movie/person")
    suspend fun getPopularArtists(@Query("api_key")apiKey:String):Response<ArtistList>

}