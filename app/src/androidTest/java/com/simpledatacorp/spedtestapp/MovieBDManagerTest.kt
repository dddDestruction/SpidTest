package com.simpledatacorp.spedtestapp

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.simpledatacorp.spedtestapp.model.db.MovieDBManager
import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*

class MovieBDManagerTest {
    private lateinit var dbManager: MovieDBManager
    val context = ApplicationProvider.getApplicationContext<Context>()
    val coroutineScope = CoroutineScope(TestCoroutineDispatcher())

    @Before
    fun createDb() {
        dbManager = MovieDBManager(context, coroutineScope)
    }

    @get:Rule
    var instantTastkExectorTest = InstantTaskExecutorRule()
    @Test
    @Throws(Exception::class)
    fun insertarYobtenerMovies()= runBlocking {
        /*
            En este test se pretente comprobar que se puede insertar y obtener data correctamente desde el
            manager de la BD
         */

        val movies1 = MovieEntity("tt1649418",
            "The Gray Man",
            "2022",
            Date(2022, 7, 22),
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
        val listaMovies = listOf(
            movies1
        )

        dbManager.inserMovies(listaMovies)

        dbManager.getMovies().observeForever {
                listaRes ->
            Truth.assertThat(listaRes).isEqualTo(listaMovies)
        }

    }

    @Test
    @Throws(Exception::class)
    fun getMovieByIdTest()= runBlocking {
        /*
            En este test se pretente comprobar que se puede obtener una película según su id
         */

        val id1 = "tt1649418"
        val id2 = "tt1649419"
        val id3 = "tt1649420"

        val movies1 = MovieEntity(id1,
            "The Gray Man",
            "2022",
            Date(2022, 7, 22),
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

        val movies2 = MovieEntity(id2,
            "The Gray Man",
            "2022",
            Date(2022, 7, 22),
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

        val movies3 = MovieEntity(id3,
            "The Gray Man",
            "2022",
            Date(2022, 7, 22),
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
        val listaMovies = listOf(
            movies1,
            movies2,
            movies3
        )
        dbManager.inserMovies(listaMovies)

        dbManager.getMovieById(id2).observeForever {
                movieRes ->
            Truth.assertThat(movies2).isEqualTo(movieRes)
        }

    }
}