package com.coffee.presentation.screens.registerScreen

//import kotlinx.serialization.SerializationStrategy
//import kotlinx.serialization.encodeToString

data class RegisterScreenState(
    val email: String = "",
    val password: String = "",
    val isSuccessful: Boolean = false
){
    /*
    fun deserializeObject(o: Any): RegisterScreenState {
        return try {
            Json.decodeFromString<RegisterScreenState>(Json.encodeToString(o))
        } catch (e: Exception){
            return RegisterScreenState()
        }
    }
     */
}