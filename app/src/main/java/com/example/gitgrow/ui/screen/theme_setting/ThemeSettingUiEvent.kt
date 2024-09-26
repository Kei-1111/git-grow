package com.example.gitgrow.ui.screen.theme_setting

sealed interface ThemeSettingUiEvent {
    data object SelectGitGrowThemeColor : ThemeSettingUiEvent
    data object SelectDynamicColor : ThemeSettingUiEvent
    data object NavigateBack : ThemeSettingUiEvent
}
