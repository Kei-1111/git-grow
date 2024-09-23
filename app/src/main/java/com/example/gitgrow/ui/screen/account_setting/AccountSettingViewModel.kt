package com.example.gitgrow.ui.screen.account_setting

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AccountSettingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AccountSettingUiState())
    val uiState: StateFlow<AccountSettingUiState> = _uiState.asStateFlow()

    fun updateUserName(userName: String) {
        _uiState.update {
            it.copy(
                userName = userName,
            )
        }
    }
}
