package com.example.gitgrow.ui.screen.theme_setting

import com.example.gitgrow.domain.model.ThemeColor

data class ThemeSettingUiState(
    val selectThemeColor: ThemeColor = ThemeColor(),
    val initialThemeColor: ThemeColor = ThemeColor(),
    val enableSaveButton: Boolean = false,
)
