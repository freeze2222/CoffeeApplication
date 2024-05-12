package com.coffee.data.utils

import com.coffee.data.models.OnboardingModel

object Constants {
    object NavDestinations{
        const val ONBOARDING = "OnBoardingWelcomeScreen"
        const val ONBOARDING_PAGER = "OnBoardingPagerScreen"
    }
    val OnboardingData = listOf(
        OnboardingModel(null,null,"coffee_background"),
        OnboardingModel("Embrace coffee \nessence","Lorem ipsum dolor sit amet consectetur. \nVestibulum eget blandit mattis ","cup_background"),
        OnboardingModel("Flavorful bean \njourney","Lorem ipsum dolor sit amet consectetur. \nVestibulum eget blandit mattis ","second_cup_background"),
        OnboardingModel("Unlock bean \nsecrets","Lorem ipsum dolor sit amet consectetur. \nVestibulum eget blandit mattis ","third_cup_background")
    )
}