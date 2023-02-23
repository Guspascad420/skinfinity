package com.example.skinfinity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.skinfinity.R

@Composable
fun EmailVerificationPage(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.group_5),
                contentDescription = null,
                modifier = Modifier.size(360.dp)
            )
        }
    }
}