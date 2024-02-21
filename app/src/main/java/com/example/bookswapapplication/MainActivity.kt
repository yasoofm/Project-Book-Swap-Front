package com.example.bookswapapplication



import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme
import com.example.bookswapapplication.composables.MainPage.BookSection
import com.example.bookswapapplication.composables.MainPage.BottomNavigationBar
import com.example.bookswapapplication.composables.MainPage.FavSection
import com.example.bookswapapplication.composables.MainPage.MostSwipedSection
import com.example.bookswapapplication.composables.MainPage.TopSection

import com.example.bookswapapplication.composables.list.BooksApp



class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookSwapApplicationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   HomeScreen()

                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun HomeScreen() {
        Scaffold(
            bottomBar = {
                BottomNavigationBar()
            }
        ) { padding ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Color.DarkGray)
            ) {

                TopSection()
                Spacer(modifier = Modifier.height(25.dp))
                BookSection()
                MostSwipedSection()

                FavSection()
                Spacer(modifier = Modifier.height(16.dp))


            }


        }



}}