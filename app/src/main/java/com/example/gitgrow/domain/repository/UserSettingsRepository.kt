package com.example.gitgrow.domain.repository

import com.example.gitgrow.domain.model.UserSettings
import kotlinx.coroutines.flow.Flow

interface UserSettingsRepository {
    val userSettings: Flow<UserSettings>

    suspend fun saveUserName(userName: String)

    suspend fun saveThemeColor(
        useGitGrowThemeColor: Boolean,
        useDynamicColor: Boolean,
    )
}
