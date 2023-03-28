package com.example.skinfinity.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skinfinity.ui.TodoGoalViewModel
import com.example.skinfinity.ui.theme.OpenSans
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddTodo(
    navController: NavHostController,
    viewModel: TodoGoalViewModel = viewModel()
) {
    Scaffold(
        topBar = { FeatureTopAppBar(navController, "Add New List") },
        bottomBar = { BottomAppBar(navController, "Home") }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(35.dp, 28.dp)
        ) {
            Text("Title", fontFamily = OpenSans, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextField(
                viewModel.title,
                { input -> viewModel.title = input },
                Modifier.fillMaxWidth().padding(bottom = 10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    textColor = MaterialTheme.colors.onSurface
                ),
                placeholder = {
                    Text(
                        "Add list title", fontFamily = OpenSans, color = Color(0xFF94A3B8)
                    )
                }
            )
            Text(
                "Description", fontFamily = OpenSans,
                fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
            TextField(
                viewModel.description,
                { input -> viewModel.description = input },
                Modifier.fillMaxWidth().padding(bottom = 10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background,
                    textColor = MaterialTheme.colors.onSurface
                ),
                placeholder = {
                    Text(
                        "Add list description", fontFamily = OpenSans,
                        color = Color(0xFF94A3B8)
                    )
                }
            )
            Text(
                "Time", fontFamily = OpenSans,
                fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
            Button({ /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6666))
            ) {
                Text(
                    "Add List", Modifier.padding(vertical = 5.dp),
                    fontFamily = OpenSans, fontWeight = FontWeight.Bold,
                    fontSize = 18.sp, color = Color.White
                )
            }
        }
    }
}