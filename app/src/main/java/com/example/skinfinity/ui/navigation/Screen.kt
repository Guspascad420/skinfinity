package com.example.skinfinity.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
    object SignUp: Screen("sign-up")
    object Login: Screen("login")
    object EmailVerification: Screen("verify-email")
    object Home: Screen("home")
    object Profile: Screen("profile")
    object TodoList: Screen("todo")
    object AddTodo: Screen("add-todo")
    object Consult: Screen("consult")
    object Goals: Screen("goals")
    object AddGoals: Screen("add-goals")
}