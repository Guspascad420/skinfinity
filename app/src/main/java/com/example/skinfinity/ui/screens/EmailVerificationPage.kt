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
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun EmailVerificationPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.group_5),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Text(
                "Verify your Email",
                fontSize = 20.sp,
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 22.dp)
            )
            Text(
                "Please verify your email address by clicking the button down below",
                fontSize = 20.sp,
                fontFamily = OpenSans,
                modifier = Modifier
                    .width(270.dp)
                    .padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(190.dp))
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFF9999),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier.width(300.dp)
        ) {
            Text("Verify", fontSize = 23.sp)
        }
        Spacer(Modifier.height(60.dp))
    }
}