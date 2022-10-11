package com.simpledatacorp.spedtestapp.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.simpledatacorp.spedtestapp.BuildConfig
import com.simpledatacorp.spedtestapp.model.api.RetrofitClient
import com.simpledatacorp.spedtestapp.model.db.MovieDBManager
import com.simpledatacorp.spedtestapp.model.entities.MovieEntity
import com.simpledatacorp.spedtestapp.model.pojo.Items
import com.simpledatacorp.spedtestapp.model.sharedPreferences.SharedPrefenrecesManager
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(context: Context, scope: CoroutineScope):IMovieRepository {

    var moviesManager = MovieDBManager(context, scope)
    var movies = moviesManager.getMovies()
    private val sharedPrefenrecesManager = SharedPrefenrecesManager(context)
    val util = MoviesUtil()

    override fun loadData() {
        val retrofit = RetrofitClient.retrofitInstance()
        val call = retrofit.getMovies(BuildConfig.API_KEY)
        call.enqueue(object : Callback<Items> {
            override fun onResponse(
                call: Call<Items>,
                response: Response<Items>
            ) {
                if (response.body() != null){
                    moviesManager.inserMovies(util.mapperApiMovie(response.body()!!))
                }
            }

            override fun onFailure(call: Call<Items>, t: Throwable) {
            }
        })
    }

    override fun insertMovies(movies: List<MovieEntity>) {
        moviesManager.inserMovies(movies)
    }

    override fun loadMovie(id: String): LiveData<MovieEntity> {
        return moviesManager.getMovieById(id)
    }

    override fun saveId(id: String) {
        sharedPrefenrecesManager.saveSelection(id)
    }

    override fun getId(): String {
        return sharedPrefenrecesManager.getIdSelected()
    }
}