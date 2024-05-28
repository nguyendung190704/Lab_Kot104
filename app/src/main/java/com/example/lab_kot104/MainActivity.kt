package com.example.lab_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                Column {
                    Greeting1("Hello , Nguyễn Tuấn Dũng - PH35067 ")
                    Greeting(0)
                }

            }
        }
    }

    @Composable
    fun Greeting(name: Int) {
        var text by remember {
            mutableStateOf(name)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "you have clicked the button $text times.",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5722),
                )
                Button(
                    onClick = { text++ },

                    ) {
                    Text(
                        text = "click me",
                        Modifier.padding(10.dp),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,

                        )
                }
            }
        }
    }
    @Composable
    fun Greeting1(name: String) {
        var text by remember {
            mutableStateOf(name)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = " $text",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF5722),
                )
                Button(
                    onClick = { text = "Hi !" },

                    ) {
                    Text(
                        text = "Say Hi",
                        Modifier.padding(10.dp),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.Serif,

                        )
                }
            }
        }
    }

}