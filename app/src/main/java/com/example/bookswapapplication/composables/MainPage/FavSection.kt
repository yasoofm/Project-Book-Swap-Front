package com.example.bookswapapplication.composables.MainPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookswapapplication.composables.MainPage.data.Fav

@Composable
fun FavSection(modifier: Modifier = Modifier, favList: List<Fav>) {
    Column (modifier = modifier){
        Text(
            text = "",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(favList) {
                FavItem(it)
                Spacer(modifier = Modifier.width(25.dp))
            }
        }
    }
}
@Composable
fun FavItem(
    fav: Fav) {
Box(modifier = Modifier
    .clip(RoundedCornerShape(25.dp))
    .background(MaterialTheme.colorScheme.secondaryContainer)
    .clickable { fav.destination() }
    .size(100.dp)) {
    Column (modifier = Modifier.padding(6.dp)){
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
