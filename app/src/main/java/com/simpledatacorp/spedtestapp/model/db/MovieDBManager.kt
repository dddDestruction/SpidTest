package com.simpledatacorp.spedtestapp.model.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieDBManager(val context: Context, val scope: CoroutineScope):IMoviesDBManager {

    var movieDao = MovieBD.getDatabase(context).dao()

    override fun getMovies(): LiveData<List<MovieEntity>> {
        return movieDao.getAllMovies()
    }

    override fun inserMovies(movies: List<MovieEntity>) = scope.launch {
        movieDao.insertMovies(movies)
    }

    override fun getMovieById(id: String): LiveData<MovieEntity> {
        return movieDao.getMovieById(id)
    }
}