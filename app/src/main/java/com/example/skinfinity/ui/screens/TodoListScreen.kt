package com.example.skinfinity.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skinfinity.ui.getCurrentDay
import com.example.skinfinity.ui.navigation.Screen
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun TodoListScreen(navController: NavHostController, active: String) {
    val days =
        mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val currentDayIndex = days.indexOf(getCurrentDay())
    val daysBeforeCurrent = days.slice(0 until currentDayIndex)
    days.removeAll(daysBeforeCurrent)
    days.addAll(daysBeforeCurrent)

    val inactiveColor = MaterialTheme.colors.surface
    val circleBorderColor = MaterialTheme.colors.onSurface

    Scaffold(
        topBar = { FeatureTopAppBar(navController, "To Do List") },
        bottomBar = { BottomAppBar(navController, "Home") },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddTodo.route) },
                backgroundColor = Color(0xFFFF6666)
            ) {
                Icon(Icons.Default.Add, null, Modifier.size(55.dp), Color.White)
            }
        }
    ) {
        LazyColumn(Modifier.padding(it)) {
            item {
                LazyRow(Modifier.padding(top = 15.dp)) {
                    items(days) { day ->
                        ClickableText(
                            text = AnnotatedString(day.substring(0, 3)),
                            onClick = { navController.navigate(Screen.TodoList.route + "/" + day) },
                            modifier = Modifier
                                .padding(28.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = circleBorderColor,
                                        radius = 83f,
                                    )
                                    drawCircle(
                                        color = if (active == day) Color(0xFFFF6666)
                                        else inactiveColor,
                                        radius = 80f,
                                    )
                                },
                            style = TextStyle(
                                color = MaterialTheme.colors.onSurface
                            )
                        )
                    }
                }
            }
            item {
                Text(
                    "$active to do list", fontFamily = OpenSans,
                    fontWeight = FontWeight.SemiBold, fontSize = 18.sp
                )
            }
        }
    }
}