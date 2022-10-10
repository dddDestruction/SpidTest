package com.simpledatacorp.spedtestapp.model

import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Items
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
}