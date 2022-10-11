package com.simpledatacorp.spedtestapp.ui.splashview

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.simpledatacorp.spedtestapp.R
import com.simpledatacorp.spedtestapp.ui.Routes
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplash(navController: NavController){
    var startAnimation by remember{
        mutableStateOf(false)
    }
    val alfaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )
    LaunchedEffect(key1 = true){
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Routes.MovieList.route)
    }
    Splash(alfaAnim.value)
}

@Composable
fun Splash(alfa: Float) {

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(R.drawable.cinema_icon),
            "LOGO", Modifier.size(120.dp).alpha(alfa))
    }
}