package com.example.lab_kot104.Lab4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab_kot104.R

class bai1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column (modifier = Modifier.fillMaxHeight()) {
            Image(
                painter =
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(20.dp))
// Username TextField
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("Username") },
            )
            Spacer(modifier = Modifier.height(8.dp))
// Password TextField
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
// Login Button
            Button(
                onClick = {
                    if (userName.isNotBlank() && password.isNotBlank()) {
                        Toast.makeText(context, "Login successful",
                            Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            context,

                            "Please enter username and password",
                            Toast.LENGTH_LONG

                        ).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.White)) {
                Text("Login")
            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting()
}