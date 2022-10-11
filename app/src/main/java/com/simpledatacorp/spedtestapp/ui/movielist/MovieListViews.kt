package com.simpledatacorp.spedtestapp.ui.movielist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.simpledatacorp.spedtestapp.R
import com.simpledatacorp.spedtestapp.model.MoviesUtil
import com.simpledatacorp.spedtestapp.selectedMovie
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie


val moviesUtil = MoviesUtil()
@Composable
fun FrontPage(viewModel: MovieListViewModel, navController: NavHostController) {
    val list by viewModel.movies.observeAsState(listOf())
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        val finalList = moviesUtil.mapperMovieToViewMovie(list)
        val lastFilm = moviesUtil.getLastFilm(finalList)
        if (lastFilm !=null) {
            TrendingMovie(
                movie = lastFilm
            )
        }
        MovieList(list = finalList, navController)
    }
}

@Composable
fun TrendingMovie(movie: ViewMovie) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text(
            text = "Now Trending",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        Row {
            Image(
                painter = rememberAsyncImagePainter(movie.image),
                contentDescription = null,
                modifier = Modifier.size(230.dp)
            )
            Column {
                Text(
                    text = movie.fullTitle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = movie.plot,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Composable
fun MovieList(list: List<ViewMovie>, navController: NavHostController) {
    Column {
        Text(
            text = "On Billboard",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyRow {
            items(list.size) { movieIndex ->
                MovieItem(movie = list[movieIndex], navController)
            }
        }
    }
}

@Composable
fun MovieItem(movie: ViewMovie, navController: NavHostController){
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .width(320.dp)
            .padding(16.dp)
    ) {
        Button(onClick = {
            selectedMovie = movie
            navController.navigate("details")
        }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(movie.image),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(3.dp)) {
                    SimpleCardText(text = movie.contentRating)
                    SimpleCardText(text = movie.genreList[0])
                    RatingCardText(text = movie.imDbRating)
                }
                Text(
                    text = movie.fullTitle,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Composable
fun SimpleCardText(text: String){
    var alfa = 1f
    if (text == ""){
        alfa = 0f
    }
    Card(
        shape = RoundedCornerShape(5.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .padding(3.dp)
            .alpha(alfa)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(5.dp)
        )
    }
}

@Composable
fun RatingCardText(text: String){
    Card(
        shape = RoundedCornerShape(5.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .padding(3.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)) {
            Image(
                painterResource(R.drawable.rating_star_24),
                ""
            )
            Text(text = text)
        }
    }
}