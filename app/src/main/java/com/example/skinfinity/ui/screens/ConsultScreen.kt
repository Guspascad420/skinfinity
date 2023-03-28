package com.example.skinfinity.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import com.example.skinfinity.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun ConsultScreen(navController: NavHostController) {
    Scaffold(bottomBar = { BottomAppBar(navController, "Consult") }) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 10.dp)
                .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                "Choose your consule method :",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold
            )
            Row(
                Modifier
                    .padding(vertical = 35.dp)
                    .fillMaxWidth(),
                Arrangement.Center
            ) {
                Surface(
                    Modifier.padding(end = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, Color(0xFFFF6666))
                ) {
                    Column(
                        Modifier.padding(vertical = 30.dp, horizontal = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(painterResource(R.drawable.group), null)
                        Text(
                            "Consule with \nDoctor", fontFamily = OpenSans,
                            color = Color(0xFFFF6666), textAlign = TextAlign.Center
                        )
                    }
                }
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(1.dp, Color(0xFFFF6666))
                ) {
                    Column(
                        Modifier.padding(vertical = 25.dp, horizontal = 15.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(painterResource(R.drawable.mdi_robot_happy), null)
                        Text(
                            "Consule with \nAI", fontFamily = OpenSans,
                            color = Color(0xFFFF6666), textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Button(
                { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6666))
            ) {
                Text(
                    "Next", Modifier.padding(vertical = 5.dp),
                    fontFamily = OpenSans, fontWeight = FontWeight.Bold,
                    fontSize = 18.sp, color = Color.White
                )
            }
        }
    }
}