package com.example.skinfinity.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun SignUpPage() {
    Surface(
        Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFCCF0),
                        Color(0xFFFF9999)
                    )
                )
            )
    ) {

    }
}