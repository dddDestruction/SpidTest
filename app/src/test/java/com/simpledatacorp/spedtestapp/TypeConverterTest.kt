package com.simpledatacorp.spedtestapp

import com.google.common.collect.BoundType
import com.google.common.collect.Range
import com.google.common.truth.Truth
import com.simpledatacorp.spedtestapp.model.db.MovieTypeConverter
import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import org.junit.Test
import java.util.*

class TypeConverterTest {

    val typeConverter = MovieTypeConverter()
    val dateLong : Long = 1658462400141
    val genrelist =
        GenreList( listOf(
            Genre("Action",
                "Action"),
            Genre("Thriller",
                "Thriller")
        ))
    val genreJson = "{\"genreList\":[{\"key\":\"Action\",\"value\":\"Action\"},{\"key\":\"Thriller\",\"value\":\"Thriller\"}]}"
    val starList = StarList(listOf(
        Stars("nm0331516",
            "Ryan Gosling"),
        Stars("nm0262635",
            "Chris Evans"),
        Stars("nm1869101",
            "Ana de Armas"),
        Stars("nm0000671",
            "Billy Bob Thornton")
    ))
    val starJson = "{\"starList\":[{\"id\":\"nm0331516\",\"name\":\"Ryan Gosling\"},{\"id\":\"nm0262635\",\"name\":\"Chris Evans\"},{\"id\":\"nm1869101\",\"name\":\"Ana de Armas\"},{\"id\":\"nm0000671\",\"name\":\"Billy Bob Thornton\"}]}"

    @Test
    fun fromDateToLongTest() {

        val date = typeConverter.fromDateToLong(getTestDate()!!)
        Truth.assertThat(date).isIn(Range.range(dateLong - 1000, BoundType.OPEN, dateLong + 1000, BoundType.OPEN) )
    }

    @Test
    fun fromGenreToJSONTest() {

        val json = typeConverter.fromGenreToJSON(genrelist)
        Truth.assertThat(json).isEqualTo(genreJson)
    }

    @Test
    fun fromJSONtoGenreTest() {

        val genreListRes = typeConverter.fromJSONtoGenre(genreJson)
        Truth.assertThat(genreListRes).isEqualTo(genrelist)
    }

    @Test
    fun fromStarToJSONTest() {

        val jsonRes = typeConverter.fromStarToJSON(starList)
        Truth.assertThat(jsonRes).isEqualTo(starJson)
    }

    @Test
    fun fromJSONtoStarTest() {

        val starlistRes = typeConverter.fromJSONtoStar(starJson)
        Truth.assertThat(starlistRes).isEqualTo(starList)
    }

    @Test
    fun fromLongToDateTest() {

        val date = typeConverter.fromLongToDate(dateLong)
        Truth.assertThat(date.toString()).isEqualTo(getTestDate().toString())
    }

    fun getTestDate(): Date?{
        val calendar = Calendar.getInstance()
        calendar.set(2022, 6, 22, 0, 0, 0)
        return calendar.time
    }
}