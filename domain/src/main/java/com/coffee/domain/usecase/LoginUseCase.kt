package com.coffee.domain.usecase

import com.coffee.domain.repository.DomainRepositoryImpl
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val domainRepositoryImpl: DomainRepositoryImpl) {
    suspend fun login(email: String, password: String){
        domainRepositoryImpl.login()
    }
}