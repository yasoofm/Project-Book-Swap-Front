package com.example.bookswapapplication.composables.MainPage.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Fav(
    val icon: ImageVector,
    val name: String,
    val background: Color,
    val destination: () -> Unit)
