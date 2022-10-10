package com.simpledatacorp.spedtestapp.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity

@Dao
interface MovieDao {

    //Inserta los valores de clima
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    //Obtiene todos los valores de clima desde Room DB
    @Query("SELECT * FROM recent_movies ORDER BY releaseState")
    fun getAllMovies(): LiveData<List<MovieEntity>>

}