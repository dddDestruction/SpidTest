package com.simpledatacorp.spedtestapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simpledatacorp.spedtestapp.ui.Routes
import com.simpledatacorp.spedtestapp.ui.moviedetail.DetailViewModel
import com.simpledatacorp.spedtestapp.ui.moviedetail.MovieDetail
import com.simpledatacorp.spedtestapp.ui.movielist.FrontPage
import com.simpledatacorp.spedtestapp.ui.movielist.MovieListViewModel
import com.simpledatacorp.spedtestapp.ui.splashview.AnimatedSplash
import com.simpledatacorp.spedtestapp.ui.theme.SpedTestAppTheme

class MainActivity : ComponentActivity() {
    private lateinit var listViewModel: MovieListViewModel
    private lateinit var detailViewModel: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpedTestAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "SpidTestApp")
                            },
                            backgroundColor = Color.Black,
                        )
                    }
                ) {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.Black
                    ) {
                        MyAppNavHost(listViewModel = listViewModel, detailViewModel = detailViewModel)
                    }
                }

            }
        }
        askForPermissions()
        listViewModel = MovieListViewModel(application)
        detailViewModel = DetailViewModel(application)
        listViewModel.load()
    }

    //Pide permisos obligatorios
    fun askForPermissions(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.CAMERA),
            1
        )
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "splash",
    listViewModel: MovieListViewModel,
    detailViewModel: DetailViewModel
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
            FrontPage(listViewModel, navController)
        }
        composable(Routes.Details.route) { MovieDetail(
            detailViewModel
        )
        }
    }
}