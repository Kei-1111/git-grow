package com.example.gitgrow.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route: String) {
    @Serializable
    data object Settings

    @Serializable
    data object AccountSetting

    @Serializable
    data object ThemeSetting
}
