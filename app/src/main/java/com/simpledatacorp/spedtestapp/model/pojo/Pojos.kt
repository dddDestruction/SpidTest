package com.simpledatacorp.spedtestapp.model.pojo

data class Items(val items: List<Movie>)

data class Movie(
    val fullTitle:String,
    val year: String,
    val releaseState: String,
    val image: String,
    val runtimeStr: String,
    val plot: String,
    val contentRating: String,
    val imDbRating: String,
    val metacriticRating: String,
    val genreList: List<Genre>,
    val directors: String,
    val starList: List<Stars>
)

data class Genre(
    val key: String,
    val value: String
)

data class Stars(
    val id: String,
    val name: String
)