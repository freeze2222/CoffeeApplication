package com.coffee.presentation.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coffee.data.utils.Constants
import com.coffee.presentation.screens.onBoardingScreen.OnBoardingPagerScreen
import com.coffee.presentation.screens.onBoardingScreen.OnBoardingWelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Constants.NavDestinations.ONBOARDING){
        composable(Constants.NavDestinations.ONBOARDING){
            EnterAnimation {
                OnBoardingWelcomeScreen(navController = navController)
            }
        }
        composable(Constants.NavDestinations.ONBOARDING_PAGER){
            EnterAnimation {
                OnBoardingPagerScreen()
            }
        }
    }
}