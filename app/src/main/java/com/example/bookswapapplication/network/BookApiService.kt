package com.example.bookswapapplication.network

import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.data.Request
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.data.request.UpdateStatusRequest
import com.example.bookswapapplication.data.response.TokenResponse
import com.example.bookswapapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface BookApiService {
    @POST(Constants.signInEndpoint)
    suspend fun signIn(@Body user: User): Response<TokenResponse>

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<String>

    @POST(Constants.addBookEndpoint)
    suspend fun addBook(
        @Header("Authorization") token: String?,
        @Body book: Book
    ): Response<String>

    @GET(Constants.getBookEndpoint)
    suspend fun getBooks(@Body user: User): Response<Book>

    @GET(Constants.getSentRequests)
    suspend fun getSentRequests(@Header("Authorization") token: String?): Response<List<Request>>

    @GET(Constants.getReceivedRequests)
    suspend fun getReceivedRequests(@Header("Authorization") token: String?): Response<List<Request>>

    @POST(Constants.swapBooks)
    suspend fun swapBooks(@Body user: User): Response<String>

    @PATCH(Constants.updateRequestStatus)
    suspend fun updateRequestStatus(@Header("Authorization") token: String?, @Query("requestID") requestId: Long, @Body updateStatusRequest: UpdateStatusRequest): Response<String>

    @GET(Constants.filterByCategory)
    suspend fun filterByCategory(@Body user: User): Response<Book>


}