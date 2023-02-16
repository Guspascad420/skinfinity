package com.example.skinfinity.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var fullName by mutableStateOf(TextFieldValue(""))
    var email by mutableStateOf(TextFieldValue(""))
    var password by mutableStateOf(TextFieldValue(""))

    fun setValue(text : TextFieldValue): (TextFieldValue) -> Unit {
        var text2 = text
        return { value -> text2 = value }
    }
}