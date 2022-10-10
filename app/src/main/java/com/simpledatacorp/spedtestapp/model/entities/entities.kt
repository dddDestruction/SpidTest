package com.simpledatacorp.spedtestapp.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.simpledatacorp.spedtestapp.model.pojo.Genre
import com.simpledatacorp.spedtestapp.model.pojo.Stars
import java.util.*

@Entity(tableName = "recent_movies")
data class MovieEntity(
    @PrimaryKey var id: String,
    val fullTitle:String,
    val year: String,
    val releaseState: Date,
    val image: String,
    val runtimeStr: String,
    val plot: String,
    val contentRating: String,
    val imDbRating: String,
    val metacriticRating: String,
    val genreList: GenreList,
    val directors: String,
    val starList: StarList
)
@Entity()
data class GenreList(
    val genreList: List<Genre>
)

@Entity()
data class StarList(
    val starList: List<Stars>
)