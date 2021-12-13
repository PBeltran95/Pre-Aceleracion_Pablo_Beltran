package ar.com.example.alkemymovieapp.repository

import ar.com.example.alkemymovieapp.data.models.*

interface MovieRepository {

    suspend fun getPopularMovies(page:Int):MovieList

    suspend fun getMovieDetails(movieId:String): MovieEntity

    suspend fun saveFavoriteMovie(favoriteMovie: MovieEntity)
}