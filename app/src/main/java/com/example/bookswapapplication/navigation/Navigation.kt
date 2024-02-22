package com.example.bookswapapplication.navigation

import BookListScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookswapapplication.composables.HomeScreen
import com.example.bookswapapplication.composables.NotificationPage
import com.example.bookswapapplication.composables.Request.ReceivedRequestsList
import com.example.bookswapapplication.composables.Request.SentRequestsList
import com.example.bookswapapplication.composables.profilePage.ProfilePage
import com.example.bookswapapplication.composables.signin.SignInScreen
import com.example.bookswapapplication.composables.signup.SignUpScreen
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.utils.Routes
import com.example.bookswapapplication.viewModel.BookViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(){
    val bookViewModel: BookViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.bookListRoute){
        composable(Routes.signupRoute){
            SignUpScreen(bookViewModel = bookViewModel, toHomeScreen = {navController.navigate(Routes.homeRoute)}, toSignIn = {navController.navigate(Routes.signInRoute)})
        }
        composable(Routes.signInRoute){
            SignInScreen(bookViewModel = bookViewModel, toSignUp = {navController.navigate(Routes.signupRoute)}, toHomeScreen = {navController.navigate(Routes.homeRoute)})
        }
        composable(Routes.homeRoute){
            HomeScreen(bookViewModel = bookViewModel,
                toAccount = {navController.navigate(Routes.accountRoute)},
                toBookList = {navController.navigate(Routes.bookListRoute)},
                toFavorites = {navController.navigate(Routes.favoritesRoute)},
                toHistory = {navController.navigate(Routes.historyRoute)},
                toNotifications = {navController.navigate(Routes.notificationRoute)},
                toWishlist = {navController.navigate(Routes.wishlistRoute)}
            )
        }
        composable(Routes.bookListRoute){
            BookListScreen(bookViewModel, {
                //bookViewModel.currentBook = it
                navController.navigate(Routes.bookDetailsRoute)
            })
        }
        composable(Routes.notificationRoute){
            bookViewModel.receivedRequests()
            ReceivedRequestsList(bookViewModel = bookViewModel)
        }
        composable(Routes.accountRoute){
            ProfilePage(User("mail", "pass", null, "phone", "name", null))
        }
        composable(Routes.addBookRoute){

        }
        composable(Routes.addRequestRoute){
            RequestPage()
        }
        composable(Routes.favoritesRoute){

        }
        composable(Routes.historyRoute){
            bookViewModel.sentRequests()
            SentRequestsList(bookViewModel = bookViewModel)
        }
        composable(Routes.wishlistRoute){

        }
    }
}
