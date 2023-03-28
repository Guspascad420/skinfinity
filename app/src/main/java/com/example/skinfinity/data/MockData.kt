package com.example.skinfinity.data

import java.time.LocalTime

data class Todo(
    val title: String,
    val description: String,
    val timestamp: LocalTime,
    val isCompleted: Boolean
)

