package com.example.bookswapapplication.data

import com.example.bookswapapplication.utils.CategoryEnum

data class Book(
    val id: Long?,
    val ISBN: Long,
    val title: String,
    val description: String,
    val author: String,
    val condition: String,
    val category: CategoryEnum,
    val image: Int?
    )
