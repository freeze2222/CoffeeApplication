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

    fun login(email: String, password: String){
        viewModelScope.launch {
            useCase.login(email, password)
        }
    }
}