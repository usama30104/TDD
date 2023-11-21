package com.example.tdd.signup

import androidx.lifecycle.ViewModel

class SignupViewModel : ViewModel() {


    var uiState = SignUpState()

    fun updateUserName(name: String) {
        uiState = uiState.copy(
            name = name
        )
    }

    fun isEmailValid(email: String) {
        val checkEmail = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$")
        val isValidEmail = email.matches(checkEmail)

        // Update uiState based on email validity
        uiState = uiState.copy(
            email = email,
            check = isValidEmail
        )
    }

    fun isPasswordValid(password: String) {
        // At least 8 characters, at least one uppercase letter, one lowercase letter, and one digit
        //val checkPassword = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$")
        val checkPassword =
            Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
        val isValidPassword = password.matches(checkPassword)
        // Update uiState based on email validity
        uiState = uiState.copy(
            password = password,
            check = isValidPassword
        )
    }


    data class SignUpState(
        val name: String = "",
        val email: String = "",
        val password: String = "",
        val check: Boolean = false
    )
}