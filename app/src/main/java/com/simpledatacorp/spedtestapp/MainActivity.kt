package com.simpledatacorp.spedtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.simpledatacorp.spedtestapp.ui.movielist.FrontPage
import com.simpledatacorp.spedtestapp.ui.movielist.MovieListViewModel
import com.simpledatacorp.spedtestapp.ui.theme.SpedTestAppTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MovieListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpedTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    FrontPage(viewModel)
                }
            }
        }
        viewModel = MovieListViewModel(application)
        viewModel.load()
    }
}