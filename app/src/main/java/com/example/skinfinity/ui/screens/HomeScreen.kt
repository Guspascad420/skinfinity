package com.example.skinfinity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.AppScreenIcon
import com.example.skinfinity.ui.HomeViewModel
import com.example.skinfinity.ui.navigation.Screen
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun HomeScreen(vm: HomeViewModel = viewModel(), navController: NavHostController) {
    Scaffold(
        topBar = { HomeTopAppBar(viewModel = vm) },
        bottomBar = { BottomAppBar(navController, "Home") }
    ) {
        LazyColumn(Modifier.padding(it)) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 15.dp)
                ) {
                    Text(
                        "My Goals",
                        fontFamily = OpenSans,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Details",
                        fontFamily = OpenSans,
                        fontSize = 14.sp,
                        color = Color(0xFFFF9999)
                    )
                }
            }
            items(2) {
                MyGoalsCard()
            }
        }
    }
}

@Composable
fun MyGoalsCard() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        for (i in 1..3) {
            Card(
                modifier = Modifier
                    .size(125.dp)
                    .padding(8.dp),
                backgroundColor = Color(0xFFFF9999),
                shape = RoundedCornerShape(15.dp)
            ) { /* TODO("Not yet implemented") */ }
        }
    }
}

@Composable
fun HomeTopAppBar(viewModel: HomeViewModel) {
    val notificationTint = if (isSystemInDarkTheme()) Color.White else Color(0xFF1E293B)
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 23.dp)
    ) {
        Row {
            Image(
                painter = painterResource(viewModel.dayIcon),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Column(Modifier.padding(start = 8.dp, top = 8.dp)) {
                Text(viewModel.dayPartGreeting(), fontFamily = OpenSans, fontSize = 17.sp)
                Text(
                    "Saul Goodman",
                    fontFamily = OpenSans,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
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

@Composable
fun BottomAppBar(
    navController: NavHostController,
    active: String
) {
    val appScreenIconList = listOf(
        AppScreenIcon("Home", R.drawable.home, R.drawable.home_active) {
            navController.navigate(Screen.Home.route)
        },
//        AppScreenIcon("Consultations", R.drawable.vector) { },
//        AppScreenIcon("Shop", R.drawable.shop) { },
//        AppScreenIcon("News", R.drawable.news) { },
        AppScreenIcon("Profile", R.drawable.profile, R.drawable.profile_active) {
            navController.navigate(Screen.Profile.route)
        }
    )

    BottomAppBar(elevation = 5.dp, backgroundColor = MaterialTheme.colors.surface) {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            appScreenIconList.forEach {
                IconButton(onClick = it.onClick) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (active == it.name) {
                            Icon(
                                painterResource(id = it.activeIconId),
                                null,
                                tint = Color(0xFFFF9999),
                            )
                            Text(
                                it.name,
                                fontFamily = OpenSans,
                                color = Color(0xFFFF9999),
                                fontSize = 12.sp
                            )
                        } else {
                            Icon(
                                painterResource(id = it.iconId),
                                null,
                                modifier = Modifier.padding(bottom = 17.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}