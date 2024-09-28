package com.example.gitgrow.domain.usecase

import com.example.gitgrow.domain.model.UserSettings
import kotlinx.coroutines.flow.Flow

interface GetUserSettingsUseCase {
    suspend operator fun invoke() : Flow<UserSettings>
}