package com.example.gitgrow.ui.screen.theme_setting

sealed interface ThemeSettingUiEvent {
    data object SelectGitGrowThemeColor : ThemeSettingUiEvent
    data object SelectDynamicColor : ThemeSettingUiEvent
    data object SaveThemeColor : ThemeSettingUiEvent
    data object SaveSuccess : ThemeSettingUiEvent
    data object SaveFailure : ThemeSettingUiEvent
    data object NavigateBack : ThemeSettingUiEvent
}
