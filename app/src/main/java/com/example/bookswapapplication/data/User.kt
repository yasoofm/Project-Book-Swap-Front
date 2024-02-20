package com.example.bookswapapplication.data

data class User(
    val email: String,
    val password: String,
    val id: Long?,
    val phoneNumber: String?,
    val name: String?,
    val token: String?
)
