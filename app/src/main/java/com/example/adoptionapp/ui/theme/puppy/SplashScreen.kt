package com.example.adoptionapp.ui.theme.puppy

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.adoptionapp.R
import com.example.adoptionapp.Routes
import kotlinx.coroutines.*

@DelicateCoroutinesApi
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(
    navController: NavController
) {
    SplashScreenContent()
    GlobalScope.launch(Dispatchers.Main) {
        delay(1000)
        navController.popBackStack()
        navController.navigate(Routes.PuppyList.route)
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.image),
            contentDescription = null,
            modifier = Modifier
                .width(125.dp)
                .height(168.dp)
                .align(Alignment.Center)
        )
    }
}