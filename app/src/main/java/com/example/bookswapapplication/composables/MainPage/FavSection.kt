package com.example.bookswapapplication.composables.MainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookswapapplication.composables.MainPage.data.Fav


val FavList = listOf(
    Fav(
        icon = Icons.Rounded.Star,
        name = "My\nFavourite",
        des="",
       background = Color.Black
    ),

    Fav(
        icon = Icons.Rounded.Favorite,
        name = "My\nWish list",
        des="",
        background = Color.Red
    ),

    Fav(
        icon = Icons.Rounded.DateRange,
        name = "My\nhistory",
        des="",
        background = Color.Black
    ),


)

@Preview
@Composable
fun FavSection() {
    Column {
        Text(
            text = "",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(FavList.size) {
                FavItem(it)
            }
        }
    }
}

@Composable
fun FavItem(
    index: Int
) {
    val fav = FavList[index]
    var lastPaddingEnd = 0.dp
    if (index == FavList.size - 1) {
        lastPaddingEnd = 16.dp
    }

    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(fav.background)
                    .padding(6.dp)
            ) {
                Icon(
                    imageVector = fav.icon,
                    contentDescription = fav.name,
                    tint = Color.White
                )
            }

            Text(
                text = fav.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

        }
    }
}
