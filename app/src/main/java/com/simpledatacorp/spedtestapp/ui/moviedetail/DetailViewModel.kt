package com.simpledatacorp.spedtestapp.ui.moviedetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.simpledatacorp.spedtestapp.model.MovieRepository
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity

class DetailViewModel(application: Application) : AndroidViewModel(application)  {

    val repository = MovieRepository(application, viewModelScope)

    fun getSavedId(): String{
        return repository.getId()
    }

    fun getFilmById(id: String): LiveData<MovieEntity> {
        return repository.loadMovie(id)
    }
}