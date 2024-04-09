package com.nuhin13.giphy.ui.navigation

sealed class Screens(val route: String)
data object SplashScreen : Screens(route = "splash_screen")
data object GiphyScreen : Screens(route = "giphy_list")