package com.coffee.presentation.screens.loginScreen

import androidx.compose.runtime.remember
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
class LoginViewModel @Inject constructor(private val useCase: LoginUseCase) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())

    val state: StateFlow<LoginScreenState>
        get() = _state.asStateFlow()

    fun login(email: String, password: String){
        viewModelScope.launch {
            useCase.login(email, password)
        }
    }
}