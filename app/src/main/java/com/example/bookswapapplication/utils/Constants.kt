package com.example.bookswapapplication.utils

class Constants {
    companion object{
        const val baseUrl = "http://10.0.2.2:8080/api/v1/"
        const val signInEndpoint = "auth/login"
        const val signupEndpoint = "auth/signup"
        const val addBookEndpoint = "add-book"
        const val getBookEndpoint = "get-books"
        const val getSentRequests = "get-sent-requests"
        const val getReceivedRequests = "get-received-requests"
        const val swapBooks = "swap"
        const val updateRequestStatus = "update-request-status"
        const val filterByCategory = "filter-by-category"
    }
}