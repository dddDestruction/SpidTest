package com.simpledatacorp.spedtestapp.model

import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.pojo.Items
import java.util.*

interface IMoviesUtil {
    //Transforma el resultado de la Api en una lista de MovieEntity
    fun mapperApiMovie(items: Items): List<MovieEntity>

    fun stringToDate(dateString: String): Date
}