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
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie
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
    fun testStringToDateTest() {

        val date = getTestDate()
        val dateRes = util.stringToDate("22 Jul 2022")
        Truth.assertThat(dateRes.toString()).isEqualTo(date.toString())
    }

    fun getTestDate(): Date?{
        val calendar = Calendar.getInstance()
        calendar.set(2022, 6, 22, 0, 0, 0)
        return calendar.time
    }



    @Test
    fun mapperGenreToListTest() {
        val genres = listOf(
                Genre("Action",
                    "Action"),
                Genre("Thriller",
                    "Thriller")
            )
        val genresTitles = listOf(
            "Action",
            "Thriller"
        )

        val gesresRes = util.mapperGenreToList(genres)
        Truth.assertThat(gesresRes.toString()).isEqualTo(genresTitles.toString())
    }

    @Test
    fun mapperStarsToListTest() {
        val stars = listOf(
            Stars("nm0331516",
                "Ryan Gosling"),
            Stars("nm0262635",
                "Chris Evans"),
            Stars("nm1869101",
                "Ana de Armas"),
            Stars("nm0000671",
                "Billy Bob Thornton")
        )

        val starsView = listOf(
            "Ryan Gosling",
            "Chris Evans",
            "Ana de Armas",
            "Billy Bob Thornton"
        )

        val starsRes = util.mapperStarsToList(stars)
        Truth.assertThat(starsRes.toString()).isEqualTo(starsView.toString())
    }

    @Test
    fun mapperMovieToViewMovieTest() {
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

        val viewMovies = listOf(
            ViewMovie("tt1649418",
                "The Gray Man",
                "2022",
                getTestDate()!!,
                "https://m.media-amazon.com/images/M/MV5BOWY4MmFiY2QtMzE1YS00NTg1LWIwOTQtYTI4ZGUzNWIxNTVmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX128_CR0,4,128,176_AL_.jpg",
                "122 mins",
                "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins.",
                "PG-13",
                "6.6",
                "49",
                util.mapperGenreToList (
                    listOf(
                        Genre("Action",
                            "Action"),
                        Genre("Thriller",
                            "Thriller")
                    )
                ),
                "Anthony Russo, Joe Russo",
                util.mapperStarsToList(
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
        val listRes = util.mapperMovieToViewMovie(movies)
        Truth.assertThat(listRes.toString()).isEqualTo(viewMovies.toString())
    }

    @Test
    fun getLastFilmTest() {
        val lastFilm = ViewMovie("tt10954984",
            "Nope (2022)",
            "2022",
            getTestDate()!!,
            "https://m.media-amazon.com/images/M/MV5BMGIyNTI3NWItNTJkOS00MGYyLWE4NjgtZDhjMWQ4Y2JkZTU5XkEyXkFqcGdeQXVyNjY1MTg4Mzc@._V1_UX128_CR0,4,128,176_AL_.jpg",
            "130 mins",
            "The residents of a lonely gulch in inland California bear witness to an uncanny and chilling discovery.",
            "R",
            "7.6",
            "77",
            util.mapperGenreToList (
                listOf(
                    Genre("Horror",
                        "Horror"),
                    Genre("Mystery",
                        "Mystery"),
                    Genre("Sci-Fi",
                        "Sci-Fi")
                )
            ),
            "Jordan Peele",
            util.mapperStarsToList(
                listOf(
                    Stars("nm2257207",
                        "Daniel Kaluuya"),
                    Stars("nm1551130",
                        "Keke Palmer"),
                    Stars("nm5155952",
                        "Brandon Perea"),
                    Stars("nm0000699",
                        "Michael Wincott")
                )
            )
        )

        val viewMovieList = listOf(
            ViewMovie("tt1649418",
                "The Gray Man",
                "2022",
                getTestDate()!!,
                "https://m.media-amazon.com/images/M/MV5BOWY4MmFiY2QtMzE1YS00NTg1LWIwOTQtYTI4ZGUzNWIxNTVmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UX128_CR0,4,128,176_AL_.jpg",
                "122 mins",
                "When the CIA's most skilled operative-whose true identity is known to none-accidentally uncovers dark agency secrets, a psychopathic former colleague puts a bounty on his head, setting off a global manhunt by international assassins.",
                "PG-13",
                "6.6",
                "49",
                util.mapperGenreToList (
                    listOf(
                        Genre("Action",
                            "Action"),
                        Genre("Thriller",
                            "Thriller")
                    )
                ),
                "Anthony Russo, Joe Russo",
                util.mapperStarsToList(
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
            ),

            ViewMovie("tt10648342",
                "Thor: Love and Thunder (2022)",
                "2022",
                getTestDate()!!,
                "https://m.media-amazon.com/images/M/MV5BYmMxZWRiMTgtZjM0Ny00NDQxLWIxYWQtZDdlNDNkOTEzYTdlXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX128_CR0,4,128,176_AL_.jpg",
                "122 mins",
                "Thor enlists the help of Valkyrie, Korg and ex-girlfriend Jane Foster to fight Gorr the God Butcher, who intends to make the gods extinct.",
                "PG-13",
                "6.8",
                "57",
                util.mapperGenreToList (
                    listOf(
                        Genre("Action",
                            "Action"),
                        Genre("Adventure",
                            "Adventure"),
                        Genre("Comedy",
                            "Comedy")
                    )
                ),
                "Taika Waititi",
                util.mapperStarsToList(
                    listOf(
                        Stars("nm1165110",
                            "Chris Hemsworth"),
                        Stars("nm0000204",
                            "Natalie Portman"),
                        Stars("nm0000288",
                            "Christian Bale"),
                        Stars("nm1935086",
                            "Tessa Thompson")
                    )
                )
            ),
            lastFilm
        )

        val viewMovie = util.getLastFilm(viewMovieList)
        Truth.assertThat(viewMovie).isEqualTo(lastFilm)
    }
}