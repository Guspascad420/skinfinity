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
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

private const val TAG = "Auth"

sealed interface AuthUiState {
    object Success : AuthUiState
    object Error : AuthUiState
    object Loading : AuthUiState
    object Default : AuthUiState
}

class AuthViewModel : ViewModel() {
    var fullName by mutableStateOf(TextFieldValue(""))
    var email by mutableStateOf(TextFieldValue(""))
    var password by mutableStateOf(TextFieldValue(""))
    private val auth: FirebaseAuth = Firebase.auth

    var authUiState: AuthUiState by mutableStateOf(AuthUiState.Default)
        private set

    fun signUpClick() {
        viewModelScope.launch {
            authUiState = AuthUiState.Loading
            auth.createUserWithEmailAndPassword(email.text, password.text)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "createUserWithEmail:success")
                        val user = auth.currentUser
                        val profileUpdates = userProfileChangeRequest {
                            displayName = fullName.text
                        }
                        user!!.updateProfile(profileUpdates)
                            .addOnCompleteListener { updateTask ->
                                if (updateTask.isSuccessful) {
                                    Log.d(TAG, "User profile updated.")
                                }
                            }
                        authUiState = AuthUiState.Success
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        authUiState = AuthUiState.Error
                    }
                }
        }

    }

    fun sendEmail(user: FirebaseUser? = auth.currentUser) {
        viewModelScope.launch {
            authUiState = AuthUiState.Loading
            user!!.sendEmailVerification()
                .addOnCompleteListener { task ->
                    authUiState = if (task.isSuccessful) {
                        Log.d(TAG, "Email sent.")
                        Firebase.auth.signOut()
                        AuthUiState.Success
                    } else {
                        AuthUiState.Error
                    }
                }
        }
    }

    fun loginClick() {
        viewModelScope.launch {
            authUiState = AuthUiState.Loading
            auth.signInWithEmailAndPassword(email.text, password.text)
                .addOnCompleteListener { task ->
                    authUiState = if (task.isSuccessful) {
                        Log.d(TAG, "Successfully Sign In User")
                        AuthUiState.Success
                    } else {
                        Log.w(TAG, "signInUser:failure", task.exception)
                        AuthUiState.Error
                    }
            }
        }
    }
}
