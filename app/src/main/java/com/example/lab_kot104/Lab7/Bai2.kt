package com.example.lab_kot104.Lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier


enum class Screen1(val route: String) {
    SCREEN1("Screen1"),
    SCREEN2("Screen2"),
    SCREEN3("Screen3"),
}

@Composable
fun Bai2() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen1.SCREEN1.route,
    ) {
        composable(Screen1.SCREEN1.route) { Screen1(navController) }
        composable(Screen1.SCREEN2.route) { Screen2(navController) }
        composable(Screen1.SCREEN3.route) { Screen3(navController) }
    }
}

@Composable
fun Screen1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                navController.navigate(Screen1.SCREEN2.route){
                    popUpTo(Screen1.SCREEN1.route) { inclusive = true }
                } },
        contentAlignment = Alignment.Center
    ) {
        Text("Screen 1", color = Color.White, fontSize = 20.sp)
    }
}
@Composable
fun Screen2(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .clickable { navController.navigate(Screen1.SCREEN3.route) },
        contentAlignment = Alignment.Center
    ) {
        Text("Screen 2", color = Color.White, fontSize = 20.sp)
    }
}
@Composable
fun Screen3(navController: NavController) {
    Box(
        modifier = Modifier.
        fillMaxSize()
            .background(Color.Green)
            .clickable { navController.navigate(Screen1.SCREEN1.route) },
        contentAlignment = Alignment.Center
    ) {
        Text("Screen 3", color = Color.White, fontSize = 20.sp)
    }
}
