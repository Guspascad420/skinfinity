package com.example.skinfinity.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TodoGoalViewModel : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
}