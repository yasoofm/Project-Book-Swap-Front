package com.example.bookswapapplication.data

import com.example.bookswapapplication.utils.Status

data class Request(
    val id: Long?,
    val sender: User,
    val receiver: User,
    val book: Book,
    val status: Status
)
