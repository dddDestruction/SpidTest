package com.simpledatacorp.spedtestapp.model.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.StarList
import java.util.*

class MovieTypeConverter {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }
    @TypeConverter
    fun fromLongToDate(date: Long): Date {
        return Date(date)
    }

    @TypeConverter
    fun fromGenreToJSON(genreList: GenreList): String {
        return Gson().toJson(genreList)
    }
    @TypeConverter
    fun fromJSONtoGenre(genreJson: String): GenreList {
        return Gson().fromJson(genreJson,GenreList::class.java)
    }

    @TypeConverter
    fun fromStarToJSON(starList: StarList): String {
        return Gson().toJson(starList)
    }
    @TypeConverter
    fun fromJSONtoStar(starJson: String): StarList {
        return Gson().fromJson(starJson,StarList::class.java)
    }
}