package com.simpledatacorp.spedtestapp.model.db

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieDBManager(val context: Context, val scope: CoroutineScope):IMoviesDBManager {

    val movieDao = MovieBD.getDatabase(context).dao()

    override fun getMovies(): LiveData<List<MovieEntity>> {
        return movieDao.getAllMovies()
    }

    override fun inserMovies(movies: List<MovieEntity>) = scope.launch {
        movieDao.insertMovies(movies)
    }
}