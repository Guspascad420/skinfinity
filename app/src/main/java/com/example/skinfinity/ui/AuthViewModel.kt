package com.example.skinfinity.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

private const val TAG = "Auth"

sealed interface AuthUiState {
    data class Success(val user: FirebaseUser?) : AuthUiState
    object Error : AuthUiState
    object Loading : AuthUiState
}

class AuthViewModel : ViewModel() {
    var fullName by mutableStateOf(TextFieldValue(""))
    var email by mutableStateOf(TextFieldValue(""))
    var password by mutableStateOf(TextFieldValue(""))
    private val auth: FirebaseAuth = Firebase.auth

    var authUiState: AuthUiState by mutableStateOf(AuthUiState.Loading)
        private set

    fun signUpClick() {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email.text, password.text)
                .addOnCompleteListener { task ->
                    authUiState = if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        AuthUiState.Success(auth.currentUser)
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        AuthUiState.Error
                    }
                }
        }
    }

}
