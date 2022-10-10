package com.simpledatacorp.spedtestapp

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth
import com.simpledatacorp.spedtestapp.model.MovieRepository
import com.simpledatacorp.spedtestapp.model.db.MovieDBManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieRepositoryTest {
    private lateinit var dbManager: MovieDBManager
    private lateinit var movieRepository: MovieRepository
    val context = ApplicationProvider.getApplicationContext<Context>()
    val coroutineScope = CoroutineScope(TestCoroutineDispatcher())

    @Before
    fun createRepository() {
        dbManager = MovieDBManager(context, coroutineScope)
        movieRepository = MovieRepository(context, coroutineScope)
    }

    @get:Rule
    var instantTastkExectorTest = InstantTaskExecutorRule()
    @Test
    @Throws(Exception::class)
    fun loadDataTest()= runBlocking {
        /*
            En este test se pretente comprobar que se puede obtener data de la API e insertarla exitósamente
         */


        movieRepository.loadData()

        dbManager.getMovies().observeForever {
                listaRes ->
            Truth.assertThat(listaRes.size).isAtLeast(5)
        }

    }

}