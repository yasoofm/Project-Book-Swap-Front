package com.example.bookswapapplication.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookswapapplication.composables.AddBook
import com.example.bookswapapplication.composables.HomeScreen
import com.example.bookswapapplication.composables.NotificationPage
import com.example.bookswapapplication.composables.Request.RequestPage
import com.example.bookswapapplication.composables.profilePage.ProfilePage
import com.example.bookswapapplication.composables.signin.SignInScreen
import com.example.bookswapapplication.composables.signup.SignUpScreen
import com.example.bookswapapplication.data.User
import com.example.bookswapapplication.utils.Routes
import com.example.bookswapapplication.viewModel.BookViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(){
    val bookViewModel: BookViewModel = viewModel();
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.signInRoute){
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
                toWishlist = {navController.navigate(Routes.wishlistRoute)},
                toAddBook = {navController.navigate(Routes.addBookRoute)}
            )
        }
        composable(Routes.bookListRoute){

        }
        composable(Routes.notificationRoute){
            NotificationPage()
        }
        composable(Routes.accountRoute){
            ProfilePage(User("mail", "pass", null, "phone", "name", null))
        }
        composable(Routes.addBookRoute){
            AddBook(modifier = Modifier, viewModel = bookViewModel, toHomeScreen = {navController.navigate(Routes.homeRoute)})
        }
        composable(Routes.addRequestRoute){
            RequestPage()
        }
        composable(Routes.favoritesRoute){

        }
        composable(Routes.historyRoute){

        }
        composable(Routes.wishlistRoute){

        }
    }
}
