package com.example.skinfinity.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skinfinity.ui.screens.*

@Composable
fun SkinfinityApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController)
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Screen.WelcomePage.route) {
        composable(Screen.WelcomePage.route) {
            WelcomePage(
                navigateToLogin = { navController.navigate(Screen.Login.route) }
            )
        }
        composable(Screen.SignUp.route) {
            SignUpPage(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginPage(
                navigateToSignUp = { navController.navigate(Screen.SignUp.route) },
                navigateToHome = { navController.navigate(Screen.Home.route) }
            )
        }
        composable(Screen.EmailVerification.route) {
            EmailVerificationPage(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.TodoList.route + "/{activeDay}") { backStackEntry ->
            val activeDay = backStackEntry.arguments?.getString("activeDay")
            TodoListScreen(navController, activeDay.toString())
        }
        composable(Screen.AddTodo.route) {
            AddTodo(navController)
        }
        composable(Screen.Consult.route) {
            ConsultScreen(navController)
        }
        composable(Screen.Goals.route) {
            GoalsScreen(navController)
        }
        composable(Screen.AddGoals.route) {
            AddGoals(navController)
        }
    }
}