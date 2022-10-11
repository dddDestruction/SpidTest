package com.simpledatacorp.spedtestapp.model

import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Items
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie
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

    override fun dateToString(date: Date): String {
        val simpleDateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
        return simpleDateFormat.format(date)
    }

    override fun mapperSingleMovieToViewMovie(movie: MovieEntity): ViewMovie {
        return ViewMovie(
            movie.id,
            movie.fullTitle,
            movie.year,
            movie.releaseState,
            movie.image,
            movie.runtimeStr,
            movie.plot,
            movie.contentRating,
            movie.imDbRating,
            movie.metacriticRating,
            mapperGenreToList(movie.genreList.genreList),
            movie.directors,
            mapperStarsToList(movie.starList.starList)
        )
    }

    override fun mapperMovieToViewMovie(movies: List<MovieEntity>): List<ViewMovie> {
        val finalList:MutableList<ViewMovie> = mutableListOf()
        movies.map {
            finalList.add(
                mapperSingleMovieToViewMovie(it)
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