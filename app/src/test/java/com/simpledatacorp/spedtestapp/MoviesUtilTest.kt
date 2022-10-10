package com.simpledatacorp.spedtestapp

import com.google.common.truth.Truth
import com.simpledatacorp.spedtestapp.model.MoviesUtil
import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Items
import com.simpledatacorp.spedtestapp.model.pojo.Movie
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import org.junit.Test
import java.util.*

class MoviesUtilTest {


    val util = MoviesUtil()

    @Test
    fun mapperApiMovieTest(){

        val items = Items(
            listOf(
                Movie(
                    "tt1649418",
                    "The Gray Man",
                    "2022",
                    "22 Jul 2022",
                    "https://m.media-amazon.com/images/M/MV5BOWY4MmFiY2QtMzE1YS00NTg1LWIwOTQtYTI4ZGUzNWIxNTVmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX128_CR0,4,128,176_AL_.jpg",
                    "122 mins",
                    "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins.",
                    "PG-13",
                    "6.6",
                    "49",
                    listOf(
                        Genre("Action",
                            "Action"),
                        Genre("Thriller",
                            "Thriller")
                    ),
                    "Anthony Russo, Joe Russo",
                    listOf(
                        Stars("nm0331516",
                            "Ryan Gosling"),
                        Stars("nm0262635",
                            "Chris Evans"),
                        Stars("nm1869101",
                            "Ana de Armas"),
                        Stars("nm0000671",
                            "Billy Bob Thornton")
                    )
                )
            )
        )

        val movies = listOf(
            MovieEntity("tt1649418",
                "The Gray Man",
                "2022",
                getTestDate()!!,
                "https://m.media-amazon.com/images/M/MV5BOWY4MmFiY2QtMzE1YS00NTg1LWIwOTQtYTI4ZGUzNWIxNTVmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX128_CR0,4,128,176_AL_.jpg",
                "122 mins",
                "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins.",
                "PG-13",
                "6.6",
                "49",
                GenreList(
                    listOf(
                        Genre("Action",
                            "Action"),
                        Genre("Thriller",
                            "Thriller")
                    )
                ),
                "Anthony Russo, Joe Russo",
                StarList(
                    listOf(
                        Stars("nm0331516",
                            "Ryan Gosling"),
                        Stars("nm0262635",
                            "Chris Evans"),
                        Stars("nm1869101",
                            "Ana de Armas"),
                        Stars("nm0000671",
                            "Billy Bob Thornton")
                    )
                )
            )
        )

        val listRes = util.mapperApiMovie(items)
        Truth.assertThat(listRes.toString()).isEqualTo(movies.toString())
    }

    @Test
    fun testStringToDate() {

        val date = getTestDate()
        val dateRes = util.stringToDate("22 Jul 2022")
        Truth.assertThat(dateRes.toString()).isEqualTo(date.toString())
    }

    fun getTestDate(): Date?{
        val calendar = Calendar.getInstance()
        calendar.set(2022, 6, 22, 0, 0, 0)
        return calendar.time
    }
}