package com.example.bookswapapplication.composables

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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookswapapplication.R
import com.example.bookswapapplication.composables.MainPage.BookSection
import com.example.bookswapapplication.composables.MainPage.BottomNavigationBar
import com.example.bookswapapplication.composables.MainPage.FavSection
import com.example.bookswapapplication.composables.MainPage.MostSwipedSection
import com.example.bookswapapplication.composables.MainPage.TopSection
import com.example.bookswapapplication.composables.MainPage.data.Fav
import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.utils.CategoryEnum

val favList = listOf(
    Fav(
        icon = Icons.Rounded.Star,
        name = "My\nFavourite",
        background = Color.Black
    ),

    Fav(
        icon = Icons.Rounded.Favorite,
        name = "My\nWish list",
        background = Color.Red
    ),

    Fav(
        icon = Icons.Rounded.DateRange,
        name = "My\nhistory",
        background = Color.Black
    ),
)
val bookrec = listOf(
    Book(
        title = "Harry Potter1",
        description = "A story about a boy with magic",
        author = "JK Rowling",
        condition = "Good",
        category = CategoryEnum.FANTASY,
        ISBN = 1234569,
        id = null,
        image = R.drawable.harry1
    ),
    Book(
        title = "Harry Potter1",
        description = "A story about a boy with magic",
        author = "JK Rowling",
        condition = "Good",
        category = CategoryEnum.FANTASY,
        ISBN = 1234569,
        id = null,
        image = R.drawable.harry2
    ),
    Book(
        title = "Harry Potter1",
        description = "A story about a boy with magic",
        author = "JK Rowling",
        condition = "Good",
        category = CategoryEnum.FANTASY,
        ISBN = 1234569,
        id = null,
        image = R.drawable.harry6
    ),
    Book(
        title = "Harry Potter1",
        description = "A story about a boy with magic",
        author = "JK Rowling",
        condition = "Good",
        category = CategoryEnum.FANTASY,
        ISBN = 1234569,
        id = null,
        image = R.drawable.harry4
    ),
)
@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(Color.DarkGray),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TopSection()
            BookSection(bookrec)
            MostSwipedSection(bookrec)
            FavSection(modifier = Modifier.align(Alignment.CenterHorizontally), favList = favList)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}