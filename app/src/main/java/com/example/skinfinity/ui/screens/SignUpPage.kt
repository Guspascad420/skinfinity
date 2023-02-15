package com.example.skinfinity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.skinfinity.R
import com.example.skinfinity.ui.theme.OpenSans
import com.example.skinfinity.ui.theme.SkinfinityTheme

@Composable
fun SignUpPage() {
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
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable._665662_3),
                contentDescription = "null",
                modifier = Modifier
                    .height(1200.dp)
                    .padding(top = 70.dp)
            )
        }
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
                Card(
                    modifier = Modifier
                        .size(width = 600.dp, height = 800.dp)
                        .padding(top = 15.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 25.dp)) {
                        Text(
                            "Sign Up",
                            fontFamily = OpenSans,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SkinfinityTheme {
        SignUpPage()
    }
}