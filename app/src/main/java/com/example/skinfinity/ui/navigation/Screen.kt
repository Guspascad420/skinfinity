package com.example.skinfinity.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
    object SignUp: Screen("sign-up")
    object Login: Screen("login")
    object EmailVerification: Screen("verify-email")
    object Home: Screen("Home")
    object Profile: Screen("Profile")
    object TodoList: Screen("todo")
}