package com.example.gitgrow.domain.usecase

import com.example.gitgrow.domain.repository.UserSettingsRepository
import javax.inject.Inject

class SaveThemeColorUseCaseImpl @Inject constructor(
    private val userSettingsRepository: UserSettingsRepository
) : SaveThemeColorUseCase {
    override suspend operator fun invoke(
        useGitGrowThemeColor: Boolean,
        useDynamicColor: Boolean,
    ) {
        userSettingsRepository.saveThemeColor(useGitGrowThemeColor, useDynamicColor)
    }
}