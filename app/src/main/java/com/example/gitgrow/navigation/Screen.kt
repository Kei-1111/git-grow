package com.example.gitgrow.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Settings : Screen

    @Serializable
    data object AccountSetting : Screen

    @Serializable
    data object ThemeSetting : Screen
}
