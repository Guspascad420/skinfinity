package com.example.skinfinity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skinfinity.R
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun WelcomePage(
    navigateToSignUp: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            Modifier
                .width(220.dp)
                .padding(top = 65.dp)) {
            Text(
                "Welcome to Skinfinity!",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 23.sp,
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable._633419_1),
            contentDescription = "null",
            modifier = Modifier
                .size(360.dp)
                .padding(vertical = 20.dp)
        )
        Column(Modifier.width(320.dp)) {
            Text(
                "Lorem ipsum dolor sit amet consectetur.",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            Text(
                "Lorem ipsum dolor sit amet consectetur. Id sed est mi viverra et. " +
                        "Fusce enim lectus eget risus fusce ut accumsan. Et proin nullam dui mi donec " +
                        "hac ornare egestas sagittis. Nunc semper urna pellentesque quisque facilisis.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(30.dp))
        Button(
            onClick = navigateToSignUp,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFF9999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.size(width = 170.dp, height = 50.dp)
        ) {
            Text("GET STARTED")
        }
    }
}