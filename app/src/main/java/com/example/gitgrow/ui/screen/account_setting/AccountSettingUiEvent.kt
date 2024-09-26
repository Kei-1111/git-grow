package com.example.gitgrow.ui.screen.account_setting

sealed interface AccountSettingUiEvent {
    data class OnUserNameChange(val value: String) : AccountSettingUiEvent
    data object SaveUserName : AccountSettingUiEvent
    data object NavigateBack : AccountSettingUiEvent
}