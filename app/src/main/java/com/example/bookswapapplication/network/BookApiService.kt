package com.example.bookswapapplication.network

import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.data.response.TokenResponse
import com.example.bookswapapplication.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface BookApiService {
    @POST(Constants.signInEndpoint)
    suspend fun signIn(@Body user: User) : Response<TokenResponse>

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<String>
}