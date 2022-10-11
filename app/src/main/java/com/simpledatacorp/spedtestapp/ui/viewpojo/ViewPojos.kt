package com.simpledatacorp.spedtestapp.ui.viewpojo

import java.util.*

data class ViewMovie(
    val id:String,
    val fullTitle:String,
    val year: String,
    val releaseState: Date,
    val image: String,
    val runtimeStr: String,
    val plot: String,
    val contentRating: String,
    val imDbRating: String,
    val metacriticRating: String,
    val genreList: List<String>,
    val directors: String,
    val starList: List<String>
)