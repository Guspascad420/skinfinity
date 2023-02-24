package com.example.skinfinity.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.skinfinity.R
import com.example.skinfinity.ui.AuthUiState
import com.example.skinfinity.ui.AuthViewModel
import com.example.skinfinity.ui.navigation.Screen
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun SignUpPage(
    vm: AuthViewModel = viewModel(),
    navController: NavHostController
) {
    LaunchedEffect(vm.authUiState) {
        if (vm.authUiState == AuthUiState.Success) {
            navController.navigate(Screen.EmailVerification.route)
        }
    }
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
            Spacer(Modifier.height(180.dp))
            Box {
                Card(
                    Modifier
                        .size(width = 600.dp, height = 800.dp)
                        .alpha(0.35f)
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                }
                SignUpInput(
                    viewModel = vm,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun BackgroundIcon() {
    Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable._665662_3),
            contentDescription = "null",
            modifier = Modifier
                .height(1200.dp)
                .padding(top = 70.dp)
        )
    }
}

@Composable
fun SignUpInput(
    viewModel: AuthViewModel,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .size(width = 600.dp, height = 800.dp)
            .padding(top = 15.dp),
        shape = RoundedCornerShape(20.dp)
    ) {

        Column(Modifier.padding(top = 25.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(
                    "Sign Up",
                    fontFamily = OpenSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                )
            }

            AuthField(
                text = viewModel.fullName,
                onValueChange = { value -> viewModel.fullName = value },
                id = R.drawable.fluent_person_48_regular,
                placeholder = "Full Name"
            )
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
                placeholder = "Password",
                visualTransformation = PasswordVisualTransformation()
            )

            Row(Modifier.padding(top = 15.dp)) {
                Text("I agree to ", fontSize = 16.sp, fontFamily = OpenSans)
                ClickableText(
                    AnnotatedString("terms & conditions"),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFF9999),
                        fontFamily = OpenSans
                    ),
                    onClick = { }
                )
            }

            Button(
                onClick = { viewModel.signUpClick() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF9999),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .size(width = 220.dp, height = 63.dp)
                    .padding(top = 15.dp)
            ) {
                Text("Register", fontSize = 20.sp)
            }

            Row(Modifier.padding(top = 15.dp)) {
                Text("Already have an account? ", fontSize = 16.sp, fontFamily = OpenSans)
                ClickableText(
                    text = AnnotatedString("Log In"),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFFFF9999),
                        fontFamily = OpenSans
                    ),
                    onClick = { navController.navigate(Screen.Login.route) }
                )
            }

        }
    }
}

@Composable
fun AuthField(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    @DrawableRes id: Int,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.background,
            textColor = MaterialTheme.colors.onSurface
        ),
        modifier = Modifier.padding(top = 25.dp),
        leadingIcon = {
            Icon(
                painterResource(id = id),
                contentDescription = null,
            )
        },
        placeholder = { Text(placeholder, color = Color(0xFF94A3B8), fontFamily = OpenSans) },
        visualTransformation = visualTransformation
    )
}