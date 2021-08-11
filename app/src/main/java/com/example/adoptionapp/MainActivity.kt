package com.example.adoptionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adoptionapp.model.PuppyModel
import com.example.adoptionapp.ui.theme.PuppyAdoptionAppTheme
import com.example.adoptionapp.ui.theme.puppy.PuppyDetails
import com.example.adoptionapp.ui.theme.puppy.PuppyList
import com.example.adoptionapp.ui.theme.puppy.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                ScreenMain()
            }
        }
    }
}

@Composable
fun ScreenMain() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {

        composable(Routes.SplashScreen.route) {

            BaseComponent { SplashScreen(navController = navController) }
        }
        composable(Routes.PuppyList.route) { BaseComponent { PuppyList(navController = navController) } }

        composable(Routes.PuppyDetails.route) {

            val puppyModel = navController.previousBackStackEntry
                ?.arguments?.getParcelable<PuppyModel>("puppy")

            if (puppyModel != null) {
                PuppyDetails(puppyModel, navController = navController)
            }

        }
    }
}

@Composable
fun BaseComponent(content: @Composable () -> Unit) {
    PuppyAdoptionAppTheme {
        content()
    }
}