package com.example.skinfinity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skinfinity.ui.screens.SignUpPage
import com.example.skinfinity.ui.screens.WelcomePage

@Composable
fun SkinfinityApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController = navController)
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.WelcomePage.route) {
        composable(route = Screen.WelcomePage.route) {
            WelcomePage(
                navigateToSignUp = { navController.navigate(Screen.SignUp.route) }
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpPage()
        }
    }
}