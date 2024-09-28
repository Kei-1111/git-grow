package com.example.gitgrow.domain.usecase

import com.example.gitgrow.domain.repository.UserSettingsRepository
import javax.inject.Inject

class GetUserSettingsUseCaseImpl @Inject constructor(
    private val userSettingsRepository: UserSettingsRepository
) : GetUserSettingsUseCase {
    override suspend operator fun invoke() = userSettingsRepository.userSettings
}