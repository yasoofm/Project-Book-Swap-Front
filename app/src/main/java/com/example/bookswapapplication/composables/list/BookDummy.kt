package com.example.bookswapapplication.composables.list

import androidx.annotation.DrawableRes

data class BookDummy(

    val id: Int,
    val title: String,
     val writer: String,
    val available: Boolean,
    @DrawableRes val imageResourceId: Int,
    @DrawableRes val ImageBanner: Int,
     val bookDetails: String
)
