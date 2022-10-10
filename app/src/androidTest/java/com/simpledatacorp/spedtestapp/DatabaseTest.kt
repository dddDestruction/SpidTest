package com.simpledatacorp.spedtestapp

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.simpledatacorp.spedtestapp.model.db.MovieBD
import com.simpledatacorp.spedtestapp.model.db.MovieDao
import com.simpledatacorp.spedtestapp.model.entities.GenreList
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.entities.StarList
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.*

@RunWith(AndroidJUnit4::class)
class DataBaseTest {
    private lateinit var dao: MovieDao
    private lateinit var db: MovieBD
    val context = ApplicationProvider.getApplicationContext<Context>()

    @get:Rule
    var instantTastkExectorTest = InstantTaskExecutorRule()
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat("com.simpledatacorp.spedtestapp").isEqualTo(appContext.packageName)
    }

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            context, MovieBD::class.java).build()
        dao = db.dao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertarYobtenerMovies()= runBlocking {
        /*
            En este test se pretente comprobar que se puede insertar y obtener data correctamente desde la base
            de datos local
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
        dao.insertMovies(listaMovies)

        dao.getAllMovies().observeForever {
                listaRes ->
            assertThat(listaMovies).isEqualTo(listaRes)
        }

    }
}

