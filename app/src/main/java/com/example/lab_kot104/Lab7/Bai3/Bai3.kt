package com.example.lab_kot104.Lab7.Bai3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.lab_kot104.Lab7.Bai3.LoginViewModel
import com.example.lab_kot104.Lab7.Bai3.ui.theme.Lab_Kot104Theme
import com.example.lab_kot104.Lab7.Navigation.Screens
import com.example.lab_kot104.R

@Composable
fun LoginScreen(navController: NavController){
    val loginViewModel : LoginViewModel = viewModel()
    LoginCard(navController,loginViewModel)
}

@Composable
fun LoginCard(navController: NavController, loginViewModel: LoginViewModel){
    val snackbarHostState = remember { SnackbarHostState() }
    HandleLoginState(snackbarHostState, loginViewModel, navController)

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) {paddingValues ->
        LoginForm(loginViewModel,paddingValues)
    }
}

@Composable
fun HandleLoginState(
    snackbarHostState: SnackbarHostState,
    loginViewModel: LoginViewModel,
    navController: NavController
){
    val isAuthenticated by loginViewModel.isAuthenticated.observeAsState()

    LaunchedEffect(key1 = isAuthenticated) {
        when(isAuthenticated){
            true -> {
                navController.navigate(Screens.Main.route){
                    popUpTo(Screens.LOGIN.route){inclusive = true}
                }
            }
            false -> {
                snackbarHostState.showSnackbar(
                    message = "Invalid username or password.",
                    duration = SnackbarDuration.Short
                )
                loginViewModel.resetAuthenticationState()
            }
            null -> {}
        }
    }
}

@Composable
fun LoginForm(
    loginViewModel: LoginViewModel,
    paddingValues: PaddingValues
){
    val usernameState by loginViewModel.username.observeAsState("")
    val rememberMeState by loginViewModel.rememberMe.observeAsState(false)
    var username by remember { mutableStateOf(usernameState) }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(rememberMeState) }
    val isLoginEnable = username.isNotBlank() && password.isNotBlank()

    LaunchedEffect(usernameState,rememberMeState) {
        username = usernameState
        rememberMe = rememberMeState
        Log.d("PAM","LoginForm : username: $usernameState rememberState : $rememberMeState")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(paddingValues),
            colors = CardDefaults.cardColors(Color.Gray),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp, 24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")

                Spacer(modifier = Modifier.height(20.dp))
                UsernameField(username, onUsernameChanges = {username = it})
                PasswordField(password, onPasswordChanges = {password = it})
                RememberMeSwitch(rememberMe){
                        isChecked -> rememberMe = isChecked
                }
                Spacer(modifier = Modifier.height(16.dp))

                LoginButton(isLoginEnable) {
                    loginViewModel.login(
                        username,
                        password,
                        rememberMe
                    )
                }
            }
        }
    }
}

@Composable
fun UsernameField(
    username : String,
    onUsernameChanges : (String) -> Unit){
    OutlinedTextField(
        value = username,
        onValueChange = onUsernameChanges,
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Username")})
}


@Composable
fun PasswordField(
    password : String,
    onPasswordChanges : (String) -> Unit){
    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChanges,
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Username")},
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun LoginButton(
    isEnable : Boolean,
    onLoginClick : () -> Unit
){
    Button(
        onClick = onLoginClick,
        enabled = isEnable,
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isEnable) Color.DarkGray else Color.LightGray,
            contentColor = Color.White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(40.dp)) {
        Text("Login", fontWeight = FontWeight.Bold)
    }
}


@Composable
fun RememberMeSwitch(
    rememberMe : Boolean,
    onCheckedChange : (Boolean) -> Unit
){
    var isChecked by remember { mutableStateOf(rememberMe) }

    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Switch(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                onCheckedChange(it)
            },
            modifier = Modifier
                .scale(0.75f)
                .padding(0.dp))
        Text(text = "Remember Me?", modifier = Modifier.padding(start = 12.dp))

    }
}
