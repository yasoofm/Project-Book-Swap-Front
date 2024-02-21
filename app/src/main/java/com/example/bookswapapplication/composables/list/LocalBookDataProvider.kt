package com.example.bookswapapplication.composables.list

import com.example.bookswapapplication.R

object LocalBookDataProvider {
    val defaultBook = getBookData()[0]
    fun getBookData(): List<Book> {
        return listOf(
            Book(
                id = 1,
                title = "Harry Potter1",
                writer =  "J.K.Rowling",
                available = true,
                imageResourceId = R.drawable.harry1,
                ImageBanner = R.drawable.harry1,
                bookDetails = "A story about a boy with magic",
            ),
            Book( id = 2,
                title = "Harry potter2",
                writer =  "J.K.Rowling",
                available = false,
                imageResourceId = R.drawable.harry2,
                ImageBanner = R.drawable.harry2,
                bookDetails = "A story about a boy with magic",
                ),
            Book( id = 3,
                title = "Harry potter3",
                writer =  "J.K.Rowling",
                available = false,
                imageResourceId = R.drawable.harry33,
                ImageBanner = R.drawable.harry33,
                bookDetails = "A story about a boy with magic",
            ),
            Book( id = 4,
                title = "Harry potter4",
                writer =  "J.K.Rowling",
                available = true,
                imageResourceId = R.drawable.harry4,
                ImageBanner = R.drawable.harry4,
                bookDetails = "A story about a boy with magic",
            ),
            Book( id = 5,
                title = "Harry potter5",
                writer = "J.K.Rowling",
                available = true,
                imageResourceId = R.drawable.harry5,
                ImageBanner = R.drawable.harry5,
                bookDetails = "A story about a boy with magic",
            ),
            Book( id = 6,
                title = "Harry potter6",
                writer = "J.K.Rowling",
                available = true,
                imageResourceId = R.drawable.harry6,
                ImageBanner = R.drawable.harry6,
                bookDetails ="A story about a boy with magic",
            ),
        )
    }
}