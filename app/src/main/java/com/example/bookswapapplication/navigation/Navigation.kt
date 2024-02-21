package com.example.bookswapapplication.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookswapapplication.composables.HomeScreen
import com.example.bookswapapplication.composables.signin.SignInScreen
import com.example.bookswapapplication.composables.signup.SignUpScreen
import com.example.bookswapapplication.utils.Routes
import com.example.bookswapapplication.viewModel.BookViewModel

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
            HomeScreen()
        }
    }
}