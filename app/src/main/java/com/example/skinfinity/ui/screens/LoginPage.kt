package com.example.skinfinity.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skinfinity.R
import com.example.skinfinity.ui.AuthViewModel
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun LoginPage(vm: AuthViewModel = viewModel()) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFCCF0),
                        Color(0xFFFF9999)
                    ),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            )
    ) {
        BackgroundIcon()
        Column(Modifier.padding(35.dp)) {
            Text(
                "It’s time to\n" +
                        "treat\n" +
                        "your skin.",
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
            Spacer(Modifier.height(240.dp))
            Box {
                Card(
                    Modifier
                        .size(width = 600.dp, height = 700.dp)
                        .alpha(0.35f)
                        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                }
                LoginInput(viewModel = vm)
            }
        }
    }
}

@Composable
fun LoginInput(viewModel: AuthViewModel) {
    Card(
        modifier = Modifier
            .size(width = 600.dp, height = 800.dp)
            .padding(top = 15.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(Modifier.padding(top = 25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(
                    "Log In",
                    fontFamily = OpenSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                )
            }

            AuthField(
                text = viewModel.email,
                onValueChange = { value -> viewModel.email = value },
                id = R.drawable.mdi_light_email,
                placeholder = "Email"
            )
            AuthField(
                text = viewModel.password,
                onValueChange = { value -> viewModel.password = value },
                id = R.drawable.carbon_password,
                placeholder = "Password"
            )

            Row(
                Modifier.padding(top = 15.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                ClickableText(
                    AnnotatedString("Forgot Password?"),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFF9999),
                        fontFamily = OpenSans
                    ),
                    modifier = Modifier.padding(end = 27.dp),
                    onClick = { }
                )
            }

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF9999),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .size(width = 220.dp, height = 70.dp)
                    .padding(top = 22.dp)
            ) {
                Text("Login", fontSize = 20.sp)
            }

            Row(Modifier.padding(top = 15.dp)) {
                Text("Don't have an account? ", fontSize = 16.sp, fontFamily = OpenSans)
                ClickableText(
                    text = AnnotatedString("Sign Up"),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFF9999),
                        fontFamily = OpenSans
                    ),
                    onClick = { }
                )
            }

        }
    }
}