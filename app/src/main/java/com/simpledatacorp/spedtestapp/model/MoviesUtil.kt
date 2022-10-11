package com.simpledatacorp.spedtestapp.model

import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Items
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*

class MoviesUtil: IMoviesUtil {
    //Convierte un objeto Items a una lista de películas
    override fun mapperApiMovie(items: Items): List<MovieEntity> {
        val finalList:MutableList<MovieEntity> = mutableListOf()
        for (it in items.items){
            finalList.add(
                MovieEntity(
                    it.id,
                    it.fullTitle,
                    it.year,
                    stringToDate(it.releaseState),
                    it.image,
                    it.runtimeStr,
                    it.plot,
                    it.contentRating,
                    it.imDbRating,
                    it.metacriticRating,
                    GenreList(it.genreList),
                    it.directors,
                    StarList(it.starList)
                )
            )
        }
        return finalList
    }

    override fun stringToDate(dateString: String): Date {
        var stringToParse = dateString.replace(" ", "-")
        val simpleDateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.US)
        val date = simpleDateFormat.parse(stringToParse)
        if (date == null){
            return Date()
        }
        return date
    }

    override fun mapperMovieToViewMovie(movies: List<MovieEntity>): List<ViewMovie> {
        val finalList:MutableList<ViewMovie> = mutableListOf()
        movies.map {
            finalList.add(
                ViewMovie(
                    it.id,
                    it.fullTitle,
                    it.year,
                    it.releaseState,
                    it.image,
                    it.runtimeStr,
                    it.plot,
                    it.contentRating,
                    it.imDbRating,
                    it.metacriticRating,
                    mapperGenreToList(it.genreList.genreList),
                    it.directors,
                    mapperStarsToList(it.starList.starList)
                )
            )
        }
        return finalList
    }

    override fun mapperGenreToList(genres: List<Genre>): List<String> {
        val finalList:MutableList<String> = mutableListOf()
        genres.map {
            finalList.add(
                it.value
            )
        }
        return finalList
    }

    override fun mapperStarsToList(stars: List<Stars>): List<String> {
        val finalList:MutableList<String> = mutableListOf()
        stars.map {
            finalList.add(
                it.name
            )
        }
        return finalList
    }

    override fun getLastFilm(list: List<ViewMovie>):ViewMovie?{
        if ( list.size - 1 == -1){
            return null
        }
        return list[list.size - 1]
    }
}