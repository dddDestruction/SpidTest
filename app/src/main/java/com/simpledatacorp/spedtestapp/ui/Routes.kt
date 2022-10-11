package com.simpledatacorp.spedtestapp.ui

sealed class Routes(val route: String){
    object Splash : Routes("splash")
    object MovieList : Routes("movieList")
    object Details : Routes("details")
}