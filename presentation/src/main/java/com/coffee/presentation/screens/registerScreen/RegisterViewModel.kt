package com.coffee.presentation.screens.registerScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffee.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val useCase: LoginUseCase) : ViewModel() {
    private val _state = MutableStateFlow(RegisterScreenState())

    val state: StateFlow<RegisterScreenState>
        get() = _state.asStateFlow()

    fun register(name: String, email: String, password: String, passwordConfirmation: String) {
        viewModelScope.launch {
            useCase.login(email, password)
        }
    }

    fun registerWithFacebook() {
        // STOPSHIP: Social media registration support
    }

    fun registerWithGoogle() {
        // STOPSHIP: Social media registration support
    }

    fun registerWithX() {
        // STOPSHIP: Social media registration support
    }
}