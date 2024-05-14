package com.coffee.presentation.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.coffee.data.utils.Constants
import com.coffee.presentation.screens.loginScreen.LoginScreen
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
                OnBoardingPagerScreen(navController)
            }
        }
        composable(Constants.NavDestinations.LOGIN){
            EnterAnimation {
                LoginScreen(navController = navController)
            }
        }
        composable(Constants.NavDestinations.REGISTER){
            EnterAnimation {
                //TODO
            }
        }
    }
}