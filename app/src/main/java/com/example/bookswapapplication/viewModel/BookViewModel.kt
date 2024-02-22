package com.example.bookswapapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookswapapplication.R
import com.example.bookswapapplication.composables.list.BookDummy
import com.example.bookswapapplication.data.Book
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.data.request.UpdateStatusRequest
import com.example.bookswapapplication.data.response.TokenResponse
import com.example.bookswapapplication.network.BookApiService
import com.example.bookswapapplication.network.RetrofitHelper
import com.example.bookswapapplication.utils.CategoryEnum
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BookApiService::class.java)

    var token: TokenResponse? by mutableStateOf(null)
    var user: User? by mutableStateOf(null)

    init {

    }
    var books: List<Book>? by mutableStateOf(null)

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
    fun addbook(
        ISBN: Long,
        title: String,
        description: String,
        author: String,
        condition: String,
        category: CategoryEnum
    ) {
        viewModelScope.launch {
            try {
                val response = apiService.addBook(Book(id = null, ISBN = ISBN, title = title,
                    author = author, description = description, condition = condition,
                    category = category, image = null ))
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun getBooks(){
        viewModelScope.launch {
            try {
                val response = apiService.getBook(token = token?.token)
                books = response.body()
            }catch (e: Exception){
                println("Error $e")
            }
        }
    }
    fun receivedRequests() {
        viewModelScope.launch {
            try {
                val response = apiService.getReceivedRequests(token = token?.token)
                receivedList = response.body()
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }
    fun updateRequestStatus(requestId: Long, status: String){
        viewModelScope.launch {
            try {
                val response = apiService.updateRequestStatus(token = token?.token, requestId = requestId, updateStatusRequest = UpdateStatusRequest(status))
            } catch (e: Exception){
                println("Error $e")
            }
        }
    }

}



