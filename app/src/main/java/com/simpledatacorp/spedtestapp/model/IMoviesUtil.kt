package com.simpledatacorp.spedtestapp.model

import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Items
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie
import java.util.*

interface IMoviesUtil {
    //Transforma el resultado de la Api en una lista de MovieEntity
    fun mapperApiMovie(items: Items): List<MovieEntity>

    fun stringToDate(dateString: String): Date

    //Transforma las peliculas obtenidas BD a películas para la vista
    fun mapperMovieToViewMovie(movies: List<MovieEntity>): List<ViewMovie>

    //Transforma los géneros obtenidas BD a lista de Strings
    fun mapperGenreToList(genres: List<Genre>): List<String>

    //Transforma los actores obtenidas BD a lista de Strings
    fun mapperStarsToList(stars: List<Stars>): List<String>

    //Obtiene el último elemento de la lista de películas o null si la lista está vacía
    fun getLastFilm(list: List<ViewMovie>):ViewMovie?
}