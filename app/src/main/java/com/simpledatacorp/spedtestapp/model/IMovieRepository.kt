package com.simpledatacorp.spedtestapp.model

import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity

interface IMovieRepository {
    //Obtiene la data de películas desde la API
    fun loadData()
    //Guarda las películas en la BBDD local
    fun insertMovies(movies: List<MovieEntity>)
    //Obtiene una pelicula guardada desde la BBDD local según su id
    fun loadMovie(id: String): LiveData<MovieEntity>
    //Guarda el id de la película seleccionada en SharedPreferences
    fun saveId(id: String)
    //Obtiene el id de la pelicula seleccionada
    fun getId(): String
}