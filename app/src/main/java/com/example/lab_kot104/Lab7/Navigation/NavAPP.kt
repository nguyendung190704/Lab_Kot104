package com.example.lab_kot104.Lab7.Navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab_kot104.Lab7.Bai1
import com.example.lab_kot104.Lab7.Bai2
import com.example.lab_kot104.Lab7.Bai3.LoginScreen
import com.example.lab_kot104.Lab7.MainViewModel
import com.example.lab_kot104.Lab7.MovieScreen2
import androidx.compose.ui.Modifier



class NavAPP : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavApp()
        }
    }
}

@Composable
fun NavApp(){
    val navController = rememberNavController()

    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())

    NavHost(navController, startDestination = Screens.LOGIN.route) {
        composable(Screens.Main.route){ MainScreen(navController)}
        composable(Screens.Bai1.route){ Bai1() }
        composable(Screens.Bai2.route){ Bai2() }
        composable(Screens.LOGIN.route){ LoginScreen(navController)}
        composable(Screens.Bai3.route){ LoginScreen(navController)}
        composable(Screens.MOVIE_SCREEN.route){ MovieScreen2(moviesState.value)}
    }
}

@Composable
fun MainScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            navController.navigate(Screens.Bai1.route)
        }) {
            Text(text = "Bài 1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Screens.Bai2.route)
        }) {
            Text(text = "Bài 2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.navigate(Screens.Bai3.route)
        }) {
            Text(text = "Bài 3")
        }
    }
}