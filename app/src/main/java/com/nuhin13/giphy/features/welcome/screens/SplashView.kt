package com.nuhin13.giphy.features.welcome.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.nuhin13.giphy.R
import com.nuhin13.giphy.ui.navigation.GiphyScreen
import com.nuhin13.giphy.ui.navigation.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun SplashView(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp),
        contentAlignment = Alignment.Center
    ) {
        val image: Painter = painterResource(id = R.drawable.giphy_svgrepo_com)
        Image(
            modifier = Modifier.padding(20.dp),
            painter = image,
            contentDescription = "Giphy Logo"
        )

        LinearProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter)) // Add padding as needed
    }


    LaunchedEffect(key1 = true) {
        delay(1500)

        navController.navigate(GiphyScreen.route) {
            popUpTo(SplashScreen.route) { inclusive = true }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashView(navController = NavHostController(context = LocalContext.current))
}