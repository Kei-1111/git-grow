package com.example.gitgrow.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.gitgrow.di.IoDispatcher
import com.example.gitgrow.domain.model.ThemeColor
import com.example.gitgrow.domain.model.UserSettings
import com.example.gitgrow.domain.repository.UserSettingsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class UserSettingsRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : UserSettingsRepository {
    companion object {
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USE_GIT_GROW_THEME_COLOR = booleanPreferencesKey("use_git_grow_theme_color")
        private val USE_DYNAMIC_COLOR = booleanPreferencesKey("use_dynamic_color")
    }

    override val userSettings: Flow<UserSettings> = dataStore.data
        .catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            UserSettings(
                userName = preferences[USER_NAME] ?: "",
                themeColor = ThemeColor(
                    useGitGrowThemeColor = preferences[USE_GIT_GROW_THEME_COLOR] ?: true,
                    useDynamicColor = preferences[USE_DYNAMIC_COLOR] ?: false,
                )
            )
        }

    override suspend fun saveUserName(userName: String) {
        withContext(ioDispatcher) {
            dataStore.edit { preferences ->
                preferences[USER_NAME] = userName
            }
        }
    }

    override suspend fun saveThemeColor(themeColor: ThemeColor) {
        withContext(ioDispatcher) {
            dataStore.edit { preferences ->
                preferences[USE_GIT_GROW_THEME_COLOR] = themeColor.useGitGrowThemeColor
                preferences[USE_DYNAMIC_COLOR] = themeColor.useDynamicColor
            }
        }
    }
}
