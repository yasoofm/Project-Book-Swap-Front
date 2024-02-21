package com.example.bookswapapplication



import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.bookswapapplication.composables.MainPage.*
import com.example.bookswapapplication.composables.profilePage.ProfilePage
import com.example.bookswapapplication.navigation.Navigation
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookswapapplication.composables.Request.RequestPage
import com.example.bookswapapplication.composables.profilePage.ProfilePage
import com.example.bookswapapplication.composables.signup.SignUpScreen
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.navigation.Navigation
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme
import com.example.bookswapapplication.viewModel.BookViewModel
import com.example.bookswapapplication.utils.CategoryEnum
import com.example.bookswapapplication.composables.list.BooksApp
import com.example.bookswapapplication.composables.profilePage.ProfilePage
import com.example.bookswapapplication.data.Request



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