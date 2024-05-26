package com.coffee.domain.repository

import com.coffee.data.models.OnboardingModel
import com.coffee.data.utils.Constants
import com.coffee.data.utils.Provider
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository{
    override suspend fun login(): List<OnboardingModel> {
        return emptyList()//Provider.provideRetrofit().getTest().execute()
    }
}