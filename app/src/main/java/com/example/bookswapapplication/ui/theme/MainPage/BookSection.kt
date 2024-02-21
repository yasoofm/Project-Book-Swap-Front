package com.example.bookswapapplication.ui.theme.MainPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookswapapplication.R
import com.example.bookswapapplication.ui.theme.MainPage.data.Bookss
import com.example.bookswapapplication.ui.theme.MainPage.data.Fav
import com.example.bookswapapplication.ui.theme.md_theme_dark_onBackground

val bookrec = listOf(
    Bookss(
        name = "Harry Potter1",
        description = "A story about a boy with magic",
        background = Color.White
    ),
    Bookss(
        name = "Harry Potter2",
        description = "A story about a boy with magic",
        background = Color.White
    ),
    Bookss(
        name = "Harry Potter3",
        description = "A story about a boy with magic",
        background = Color.White
    ),
    Bookss(
        name = "Harry Potter4",
        description = "A story about a boy with magic",
        background = Color.Unspecified
    ),

    )

@Preview
@Composable
fun BookSection() {
    Text(
        text = "Recommendations:",
        fontSize = 24.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(16.dp)
    )
    LazyRow {
        items(bookrec.size) { index ->
            recItem(index)
        }
    }
}

@Composable
fun recItem(
    index: Int
) {
    val card = bookrec[index]
    var lastItemPaddingEnd = 0.dp
    if (index == bookrec.size - 1) {
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.harry1)
    if (card.name == "Harry Potter1") {
        image = painterResource(id = R.drawable.harry2)
    }

    Spacer(modifier = Modifier.height(10.dp))

    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.background)
                .width(240.dp)
                .height(160.dp)
                .padding(vertical = 25.dp, horizontal = 25.dp),
            //  verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = image,
                contentDescription = card.name,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(10.dp))
            Column {

                Text(
                    text = card.name,
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = " ${card.description}",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Thin
                )
            }


        }
    }
}


@Preview
@Composable
fun PreviewBookSection() {
    BookSection()
}



