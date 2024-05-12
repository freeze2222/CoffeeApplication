package com.coffee.presenation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coffee.data.utils.Constants

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = ""){
        composable(Constants.NavDestinations.ONBOARDING){

        }
    }
}