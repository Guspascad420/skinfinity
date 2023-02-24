package com.example.skinfinity.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.skinfinity.ui.HomeViewModel
import com.example.skinfinity.ui.theme.OpenSans

@Composable
fun HomeScreen(vm: HomeViewModel = viewModel()) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Row(Modifier.padding(start = 12.dp, top = 12.dp)) {
            Image(
                painter = painterResource(vm.dayIcon),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Column {
                Text(vm.dayPartGreeting(), fontFamily = OpenSans, fontSize = 24.sp)
            }
        }
    }
}