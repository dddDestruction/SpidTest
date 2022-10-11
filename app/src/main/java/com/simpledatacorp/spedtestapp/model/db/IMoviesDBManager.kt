package com.simpledatacorp.spedtestapp.model.db

import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import kotlinx.coroutines.Job

interface IMoviesDBManager {
    //Obtiene las películes guardadas en la base de datos
    fun getMovies(): LiveData<List<MovieEntity>>
    //Inserta las películes en la base de datos
    fun inserMovies(movies: List<MovieEntity>): Job
    //obtiene una película según su id
    fun getMovieById(id: String): LiveData<MovieEntity>
}