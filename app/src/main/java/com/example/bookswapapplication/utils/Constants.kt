package com.example.bookswapapplication.utils

class Constants {
    companion object{
        const val baseUrl = "http://10.0.2.2:8080/api/v1/"
        const val signInEndpoint = "auth/login"
        const val signupEndpoint = "auth/signup"
        const val addBookEndpoint = "user/add-book"
        const val getBookEndpoint = "user/get-books"
        const val getSentRequests = "user/get-sent-requests"
        const val getReceivedRequests = "user/get-received-requests"
        const val swapBooks = "user/swap"
        const val updateRequestStatus = "user/update-request-status"
        const val filterByCategory = "user/filter-by-category"
    }
}