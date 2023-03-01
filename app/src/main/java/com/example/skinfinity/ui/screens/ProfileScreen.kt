package com.example.skinfinity.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.AppScreenIcon
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun ProfileScreen(navController: NavHostController) {
    Scaffold(
        topBar = { ProfileTopAppBar() },
        bottomBar = { BottomAppBar(navController, active = "Profile") }
    ) {
        Column(Modifier.padding(it)) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painterResource(R.drawable.profile_pic),
                    null,
                    Modifier
                        .border(BorderStroke(4.dp, Color(0xFFFF3333)), CircleShape)
                        .size(160.dp)
                )
                Text(
                    "Saul Goodman",
                    fontFamily = OpenSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 20.dp)
                )
                Text(
                    "saulgoodman@gmail.com",
                    fontFamily = OpenSans,
                    fontSize = 14.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color(0xFF475569)
                )
            }
            AccountSettings()
        }
    }
}

@Composable
fun AccountSettings() {
    val accountSettingsList = listOf(
        AppScreenIcon("Account details", R.drawable.as_profile),
        AppScreenIcon("Update password", R.drawable.as_password),
        AppScreenIcon("My skin", R.drawable.teenyicons_face_id_outline),
        AppScreenIcon("Payment", R.drawable.ph_credit_card),
        AppScreenIcon("Log out", R.drawable.logout)
    )
    Column(Modifier.padding(35.dp)) {
        Text(
            "Account settings",
            fontFamily = OpenSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color(0xFFFF6666)
        )
        accountSettingsList.forEach {
            val color = if (it.name == "Login") Color.Red else MaterialTheme.colors.onSurface
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row {
                    Icon(painterResource(it.iconId), null)
                    Text("Account details", Modifier.padding(start = 8.dp), color = color)
                }
                Icon(Icons.Default.KeyboardArrowRight, null, tint = color)
            }
        }
    }
}

@Composable
fun ProfileTopAppBar() {
    val notificationTint = if (isSystemInDarkTheme()) Color.White else Color(0xFF1E293B)
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 23.dp)
    ) {
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