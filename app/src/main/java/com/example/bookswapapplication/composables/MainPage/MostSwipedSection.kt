package com.example.bookswapapplication.composables.MainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookswapapplication.R
import com.example.bookswapapplication.data.Book

@Composable
fun MostSwipedSection(bookSwipe: List<Book>) {
    Text(
        text = "Most Swiped Books:",
        fontSize = 24.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
    LazyRow {
        items(bookSwipe) { book ->
            SwipeItem(book)
        }
    }
}
@Composable
fun SwipeItem(
    book: Book
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(Color.White)
                .width(240.dp)
                .height(160.dp)
                .padding(vertical = 25.dp, horizontal = 25.dp),
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = book.image?: R.drawable.harry6),
                contentDescription = book.title,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(20.dp).width(10.dp))
            Column {
                Text(
                    text = book.title,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = book.description,
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }
}
