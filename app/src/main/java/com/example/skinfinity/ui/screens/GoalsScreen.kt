package com.example.skinfinity.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.skinfinity.ui.navigation.Screen

@Composable
fun GoalsScreen(navController: NavHostController) {
    Scaffold(
        topBar = { FeatureTopAppBar(navController, "My Goals") },
        bottomBar = { BottomAppBar(navController, "Home") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddGoals.route) },
                backgroundColor = Color(0xFFFF6666)
            ) {
                Icon(Icons.Default.Add, null, Modifier.size(55.dp), Color.White)
            }
        }
    ) {
        Column(Modifier.padding(it)) {

        }
    }
}