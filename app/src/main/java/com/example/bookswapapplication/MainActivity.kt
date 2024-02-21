package com.example.bookswapapplication



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bookswapapplication.composables.HomeScreen
import com.example.bookswapapplication.composables.MainPage.BookSection
import com.example.bookswapapplication.composables.MainPage.BottomNavigationBar
import com.example.bookswapapplication.composables.MainPage.FavSection
import com.example.bookswapapplication.composables.MainPage.MostSwipedSection
import com.example.bookswapapplication.composables.MainPage.TopSection
import com.example.bookswapapplication.composables.MainPage.data.Fav
import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.navigation.Navigation
import com.example.bookswapapplication.ui.theme.BookSwapApplicationTheme
import com.example.bookswapapplication.utils.CategoryEnum


class MainActivity : ComponentActivity() {

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