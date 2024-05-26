package com.coffee.presentation.screens.loginScreen

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val isSuccessful: Boolean = false
)