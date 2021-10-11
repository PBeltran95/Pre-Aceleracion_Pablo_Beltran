package ar.com.example.alkemymovieapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


data class Movie(
    val id: Int = -1,
    val adult:Boolean = false,
    val backdrop_path: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1
)


data class MovieList(
    val results: List<Movie> = listOf()
)

data class MovieDetail(
    val id: Int = -1,
    val adult:Boolean = false,
    val backdrop_path: String = "",
    val genres : List<Genres> = listOf(),
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = -1.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = -1.0,
    val vote_count: Int = -1
)
data class Genres(
    val id:Int = -1,
    val name:String = ""
)


@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val adult:Boolean = false,
    val backdrop_path: String = "",
    val genres: String = "",
    val original_title: String = "",
    val original_language: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0
)

fun MovieDetail.toMovieEntity():MovieEntity = MovieEntity(
    this.id,
    this.adult,
    this.backdrop_path,
    this.genres.map { it.name }.toString(),
    this.original_title,
    this.original_language,
    this.overview,
    this.popularity,
    this.poster_path,
    this.release_date,
    this.title,
    this.video,
    this.vote_average,
    this.vote_count
)