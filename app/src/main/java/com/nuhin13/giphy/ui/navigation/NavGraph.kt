package com.nuhin13.giphy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nuhin13.giphy.features.giphylist.presentaion.GiphyListScreen
import com.nuhin13.giphy.features.welcome.screens.SplashView

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = SplashScreen.route
    ) {
        composable(route = SplashScreen.route) {
            SplashView(navController = navController)
        }
        composable(route = GiphyScreen.route) {
            GiphyListScreen(giphyListViewModel = hiltViewModel())
        }
    }
}