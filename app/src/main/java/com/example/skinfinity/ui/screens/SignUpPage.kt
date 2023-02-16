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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skinfinity.R
import com.example.skinfinity.ui.AuthViewModel
import com.example.skinfinity.ui.theme.OpenSans
import com.example.skinfinity.ui.theme.SkinfinityTheme

@Composable
fun SignUpPage(vm: AuthViewModel = viewModel()) {
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
                SignUpInput(viewModel = vm)
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
fun SignUpInput(viewModel: AuthViewModel) {
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

            SignUpField(
                text = viewModel.fullName,
                onValueChange = { value -> viewModel.fullName = value },
                id = R.drawable.fluent_person_48_regular,
                placeholder = "Full Name"
            )
            SignUpField(
                text = viewModel.email,
                onValueChange = { value -> viewModel.email = value },
                id = R.drawable.mdi_light_email,
                placeholder = "Email"
            )
            SignUpField(
                text = viewModel.password,
                onValueChange = { value -> viewModel.password = value },
                id = R.drawable.carbon_password,
                placeholder = "Password"
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
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFF9999),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(15.dp),
                modifier = Modifier
                    .size(width = 150.dp, height = 60.dp)
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
                    onClick = { }
                )
            }

        }
    }
}

@Composable
fun SignUpField(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    @DrawableRes id: Int,
    placeholder: String
) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
        modifier = Modifier.padding(top = 25.dp),
        leadingIcon = {
            Icon(
                painterResource(id = id),
                contentDescription = null
            )
        },
        placeholder = { Text(placeholder, color = Color(0xFF94A3B8), fontFamily = OpenSans) }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SkinfinityTheme {
        SignUpPage()
    }
}