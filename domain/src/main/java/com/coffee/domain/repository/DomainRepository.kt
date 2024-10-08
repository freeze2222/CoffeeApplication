package com.coffee.domain.repository

import com.coffee.data.models.OnboardingModel

interface DomainRepository {
    suspend fun login(): List<OnboardingModel>
}