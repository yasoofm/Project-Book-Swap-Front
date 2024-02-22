package com.example.bookswapapplication.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bookswapapplication.composables.MainPage.BottomNavigationBar
import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.data.request.SwapRequest
import com.example.bookswapapplication.utils.Status
import com.example.bookswapapplication.viewModel.BookViewModel

@Composable
fun BooksListPage(bookViewModel: BookViewModel, toBookList: () -> Unit, toNotifications: () -> Unit, toAccount: () -> Unit, toHomeScreen: () -> Unit) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                toBookList = toBookList,
                toNotifications = toNotifications,
                toAccount = toAccount,
                toHomeScreen = toHomeScreen
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(padding)){
            items(bookViewModel.bookList?: listOf()){
                BookCard(book = it, bookViewModel = bookViewModel)
            }
        }

    }
}

@Composable
fun BookCard(book: Book, bookViewModel: BookViewModel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .clickable { }
    ) {
        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()){
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Title: ${book.title}",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Author: ${book.author}",
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "ISBN: ${book.ISBN}",
                )
            }
            Button(
                onClick = { bookViewModel.requestSwap(SwapRequest(receiverId = 1, bookId = book.id!!)) },
                ) {
                Text(text = "Request Swap")
            }
        }

    }
}