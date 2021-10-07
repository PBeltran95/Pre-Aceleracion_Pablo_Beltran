package ar.com.example.alkemymovieapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ar.com.example.alkemymovieapp.data.models.MovieEntity


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: MovieEntity)

    @Query("SELECT * FROM movieentity WHERE id = :movie_id")
    suspend fun loadMovie(movie_id:Int):MovieEntity

}