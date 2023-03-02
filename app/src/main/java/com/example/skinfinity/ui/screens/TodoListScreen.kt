package com.example.skinfinity.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun TodoListScreen(navController: NavHostController) {
    Scaffold(topBar = { TodoTopAppBar() }, bottomBar = { BottomAppBar(navController, "Home") }) {
        LazyColumn(Modifier.padding(it)) {

        }
    }
}

@Composable
fun TodoTopAppBar() {
    val notificationTint = if (isSystemInDarkTheme()) Color.White else Color(0xFF1E293B)
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painterResource(R.drawable.back_button), "back button")
        }
        Text(
            "To Do List",
            fontFamily = OpenSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(R.drawable.clarity_notification_line),
                contentDescription = null,
                modifier = Modifier
                    .width(45.dp)
                    .padding(top = 15.dp),
                tint = notificationTint
            )
        }
    }
}