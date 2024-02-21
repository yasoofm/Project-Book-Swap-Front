package com.example.bookswapapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.data.response.TokenResponse
import com.example.bookswapapplication.network.BookApiService
import com.example.bookswapapplication.network.RetrofitHelper
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BookApiService::class.java)

    var token: TokenResponse? by mutableStateOf(null)
    var user: User? by mutableStateOf(null)

    fun signup(email: String, password: String, name: String, phoneNumber: String) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(email, password,null, phoneNumber, name,null))
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun signIn(username: String, password: String, toHomeScreen: () -> Unit){
        viewModelScope.launch {
            try {
                val response = apiService.signIn(User(username, password,null, null, null, null))
                token = response.body()
                println("TOKEN SIGNIN ${token?.token}")
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                if (token != null){
                    toHomeScreen()
                }
            }
        }
    }
}



