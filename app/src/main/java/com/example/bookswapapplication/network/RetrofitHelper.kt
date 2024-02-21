package com.example.bookswapapplication.network

import com.example.bookswapapplication.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}