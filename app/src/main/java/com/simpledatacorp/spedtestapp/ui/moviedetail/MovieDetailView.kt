package com.simpledatacorp.spedtestapp.ui.moviedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.simpledatacorp.spedtestapp.R
import com.simpledatacorp.spedtestapp.model.MoviesUtil
import com.simpledatacorp.spedtestapp.ui.movielist.SimpleCardText
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie


val moviesUtil = MoviesUtil()

@Composable
fun MovieDetail(movie: ViewMovie) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())) {
            Row(modifier = Modifier
                .horizontalScroll(rememberScrollState())) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier.wrapContentSize()
                ){
                    Image(
                        painter = rememberAsyncImagePainter(movie.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(230.dp)
                            .padding(5.dp)
                    )
                }
                Column() {
                    MetacriticScore(text = movie.metacriticRating)
                    ImdbScore(text = movie.imDbRating)
                    SimpleCardText(text = movie.contentRating)
                }
            }
            Text(
                text = movie.fullTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp)
            )
            StringsList(list = movie.genreList)
            Text(
                text = movie.plot,
                fontSize = 16.sp,
            )
            Text(
                text = stringResource(R.string.actors),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 10.dp)
            )
            StringsList(list = movie.starList)
            Card(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                modifier = Modifier.align(alignment = Alignment.End)
            ) {
                SimpleCardText(
                    text = moviesUtil.dateToString(movie.releaseState)
                )
            }
        }
    }
}

@Composable
fun StringsList(list: List<String>) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 10.dp)) {
        LazyRow() {
            items(list.size) { genreIndex ->
                SimpleCardText(text = list[genreIndex])
            }
        }
    }
}

@Composable
fun MetacriticScore(text: String){
    val showText = text + "/100"
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.padding(3.dp)
    ) {
        Row(modifier = Modifier
            .padding(5.dp)) {
            Image(
                painterResource(R.drawable.metacritic_icon),
                "",
                modifier = Modifier.size(20.dp)
            )
            Text(text = showText, Modifier.padding(5.dp, 0.dp))
        }
    }
}

@Composable
fun ImdbScore(text: String){
    val showText = text + "/10"
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = Modifier.padding(3.dp)
    ) {
        Row(modifier = Modifier
            .padding(5.dp)) {
            Image(
                painterResource(R.drawable.imdb_logo),
                "",
                modifier = Modifier.size(20.dp)
            )
            Text(text = showText, Modifier.padding(5.dp, 0.dp))
        }
    }
}