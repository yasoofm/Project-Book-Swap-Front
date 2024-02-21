package com.example.bookswapapplication.composables.list

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Book(

    val id: Int,
    val title: String,
     val writer: String,
    val available: Boolean,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val ImageBanner: Int,
     val bookDetails: String
)
