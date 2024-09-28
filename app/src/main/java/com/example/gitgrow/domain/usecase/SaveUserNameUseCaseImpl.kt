package com.example.gitgrow.domain.usecase

import com.example.gitgrow.domain.repository.UserSettingsRepository
import javax.inject.Inject

class SaveUserNameUseCaseImpl @Inject constructor(
    private val userSettingsRepository: UserSettingsRepository
) : SaveUserNameUseCase {
    override suspend operator fun invoke(userName: String) {
        userSettingsRepository.saveUserName(userName)
    }
}