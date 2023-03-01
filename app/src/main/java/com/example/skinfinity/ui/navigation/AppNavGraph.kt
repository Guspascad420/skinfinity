package com.example.skinfinity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skinfinity.ui.screens.*

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
                navigateToLogin = { navController.navigate(Screen.Login.route) }
            )
        }
        composable(route = Screen.SignUp.route) {
            SignUpPage(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginPage(
                navigateToSignUp = { navController.navigate(Screen.SignUp.route) },
                navigateToHome = { navController.navigate(Screen.Home.route) }
            )
        }
        composable(route = Screen.EmailVerification.route) {
            EmailVerificationPage(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}