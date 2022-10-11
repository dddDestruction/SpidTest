package com.simpledatacorp.spedtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simpledatacorp.spedtestapp.ui.Routes
import com.simpledatacorp.spedtestapp.ui.moviedetail.MovieDetail
import com.simpledatacorp.spedtestapp.ui.movielist.FrontPage
import com.simpledatacorp.spedtestapp.ui.movielist.MovieListViewModel
import com.simpledatacorp.spedtestapp.ui.splashview.AnimatedSplash
import com.simpledatacorp.spedtestapp.ui.theme.SpedTestAppTheme
import com.simpledatacorp.spedtestapp.ui.viewpojo.ViewMovie

var selectedMovie: ViewMovie? = null
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MovieListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpedTestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    MyAppNavHost(viewModel = viewModel)
                }
            }
        }
        viewModel = MovieListViewModel(application)
        viewModel.load()
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "splash",
    viewModel: MovieListViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Routes.Splash.route) {
            AnimatedSplash(navController)
        }
        composable(Routes.MovieList.route) {
            FrontPage(viewModel, navController)
        }
        composable(Routes.Details.route) { MovieDetail(
            selectedMovie!!
        )
        }
    }
}