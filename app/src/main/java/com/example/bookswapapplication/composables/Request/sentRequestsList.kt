package com.example.bookswapapplication.composables.Request

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bookswapapplication.data.Request
import com.example.bookswapapplication.utils.Status
import com.example.bookswapapplication.viewModel.BookViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sentRequestsList(requests: List<Request>, bookViewModel: BookViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Swap Requests") },
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(requests) { request ->
                RequestCard(request = request)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun RequestCard(request: Request) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Receiver: ${request.receiver}",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Book: ${request.book}",
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Status: ${request.status}",
                color = if (request.status == Status.ACCEPTED) Color.Green else Color.Red
            )
        }
    }
}
