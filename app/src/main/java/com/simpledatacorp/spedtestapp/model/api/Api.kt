package com.simpledatacorp.spedtestapp.model.api

import com.simpledatacorp.spedtestapp.model.pojo.Items
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    //Obtiene las películes de la api
    @GET("movies.json")
    fun getMovies(@Query("key") key:String): Call<Items>
}