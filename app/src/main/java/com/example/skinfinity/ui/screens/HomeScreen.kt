package com.example.skinfinity.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.AppScreenIcon
import com.example.skinfinity.ui.HomeViewModel
import com.example.skinfinity.ui.getCurrentDay
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
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp, vertical = 15.dp)
                ) {
                    Text(
                        "To Do List",
                        fontFamily = OpenSans,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    ClickableText(
                        text = AnnotatedString("Details"),
                        style = TextStyle(
                            fontFamily = OpenSans,
                            fontSize = 14.sp,
                            color = Color(0xFFFF9999)
                        ),
                        onClick = {
                            navController.navigate(Screen.TodoList.route + "/" + getCurrentDay())
                        }
                    )
                }
            }
            items(vm.todoLists) { todo ->
                TodoItems(
                    title = todo.title,
                    description = todo.description,
                    timestamp = todo.timestamp.toString(),
                    isCompleted = todo.isCompleted
                )
            }
            item {
                Text(
                    "News", Modifier.padding(start = 20.dp, top = 15.dp, bottom = 10.dp),
                    fontFamily = OpenSans, fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
            items(vm.newsImage) { imageId ->
                NewsSection(imageId)
            }
        }
    }
}

@Composable
fun TodoItems(title: String, description: String, timestamp: String, isCompleted: Boolean) {
    val completedIcon = if (isCompleted) R.drawable.group_63 else R.drawable.group_62
    Row(
        Modifier
            .padding(horizontal = 30.dp, vertical = 7.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                title,
                fontFamily = OpenSans,
                color = Color(0xFFFF9999),
                fontWeight = FontWeight.Bold
            )
            Text(description, Modifier.width(250.dp))
            Row(Modifier.padding(top = 8.dp)) {
                Icon(
                    painter = painterResource(R.drawable.ph_clock_afternoon_thin),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 3.dp)
                )
                Text(timestamp)
            }
        }
        Image(
            painter = painterResource(completedIcon),
            contentDescription = null,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

@Composable
fun NewsSection(@DrawableRes imageId: Int) {
    Row(
        Modifier
            .padding(horizontal = 20.dp, vertical = 15.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                "Lorem ipsum dolor sit amet\n" +
                        "consectetur. Turpis leo posuere\n" +
                        "nam sed commodo non\n" +
                        "ullamcorper morbi nisl.",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold
            )
            Row(Modifier.width(250.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("CNN Indonesia", fontFamily = OpenSans, color = Color(0xFF64748B))
                Text("12 Hours Ago", fontFamily = OpenSans, color = Color(0xFF64748B))
            }
        }
        Image(painterResource(imageId), null)
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
        AppScreenIcon("Consult", R.drawable.consult, R.drawable.consult_active) {
            navController.navigate(Screen.Consult.route)
        },
        AppScreenIcon("Shop", R.drawable.shop, R.drawable.shop_active) { },
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

@Composable
fun FeatureTopAppBar(navController: NavHostController, name: String) {
    val notificationTint = if (isSystemInDarkTheme()) Color.White else Color(0xFF1E293B)
    Row(Modifier.fillMaxWidth().padding(horizontal = 10.dp), Arrangement.SpaceBetween) {
        Box(Modifier.padding(top = 10.dp)) {
            IconButton({ navController.popBackStack() }) {
                Icon(painterResource(R.drawable.back_button), "back button")
            }
        }
        Text(
            name,
            Modifier.padding(top = 20.dp),
            fontFamily = OpenSans,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFFFF9999)
        )
        Box(Modifier.padding(top = 15.dp)) {
            IconButton(onClick = { /*TODO*/ }, Modifier.size(40.dp)) {
                Icon(
                    painterResource(R.drawable.clarity_notification_line),
                    null,
                    Modifier.size(40.dp),
                    notificationTint
                )
            }
        }
    }
}
