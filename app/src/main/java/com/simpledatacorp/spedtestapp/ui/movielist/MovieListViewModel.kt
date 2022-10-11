package com.simpledatacorp.spedtestapp.ui.movielist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.simpledatacorp.spedtestapp.model.MovieRepository

class MovieListViewModel(application: Application) : AndroidViewModel(application)  {

    val repository = MovieRepository(application, viewModelScope)
    val movies = repository.movies

    fun load(){
        repository.loadData()
    }
}