package com.example.bookswapapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import Booklistscreen
import com.example.bookswapapplication.navigation.Navigation
import com.example.bookswapapplication.viewModel.BookViewModel


class MainActivity : ComponentActivity() {




    @RequiresApi(Build.VERSION_CODES.O)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSwapApplicationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()

                }
            }
        }
    }
}