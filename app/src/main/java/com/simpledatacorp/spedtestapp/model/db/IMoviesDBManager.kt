package com.simpledatacorp.spedtestapp.model.db

import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity

interface IMoviesDBManager {
    //Obtiene las películes guardadas en la base de datos
    fun getMovies(): LiveData<List<MovieEntity>>
    //Inserta las películes en la base de datos
    fun inserMovies(movies: List<MovieEntity>)
}