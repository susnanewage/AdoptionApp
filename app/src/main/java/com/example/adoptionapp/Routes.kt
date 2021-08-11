package com.example.adoptionapp

sealed class Routes(val route: String) {
    object SplashScreen : Routes("splashScreen")
    object PuppyList : Routes("puppyList")
    object PuppyDetails : Routes("puppyDetails")
}

