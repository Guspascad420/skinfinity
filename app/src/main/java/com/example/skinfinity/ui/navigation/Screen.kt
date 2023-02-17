package com.example.skinfinity.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
    object SignUp: Screen("sign-up")
    object Login: Screen("login")
}