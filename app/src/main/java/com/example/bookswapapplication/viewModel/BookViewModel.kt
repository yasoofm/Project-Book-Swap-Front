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

    fun signup(username: String, password: String, navigation: () -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password,1,"","",null))
                token = response.body()
            } catch (e: Exception) {
                println("Error $e")
            } finally {
                if (token != null) {
                    navigation()
                }
            }

        }
    }

//    fun signIn2(user:User){
//        viewModelScope.launch {
//            try {
//                val response = apiService.signIn(user)
//                token = response.body()
//                println("TOKEN SIGNIN ${token?.token}")
//
//
//            } catch (e: Exception) {
//                println("Error $e")
//            }
//        }
//
//    }

    fun signIn(username: String,password: String){
        viewModelScope.launch {
            try {
                val response = apiService.signIn(User(username, password,null, null, null, null))
                token = response.body()
                println("TOKEN SIGNIN ${token?.token}")


            } catch (e: Exception) {
                println("Error $e")
            }
        }

    }

    }



