package com.ondev.daggerhilttest.ui.screens.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ondev.daggerhilttest.ui.theme.DaggerHiltTestTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(
    randomViewModel: RandomViewModel = hiltViewModel()
) {
    val randNumber = randomViewModel.randomNum.collectAsState(0)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = randNumber.value.toString())
            Button(onClick = {
                randomViewModel.onRandomChange()

            }) {
                Icon(Icons.Default.Refresh, contentDescription = null)
                Text(text = "Refresh")
            }
        }
    }
}