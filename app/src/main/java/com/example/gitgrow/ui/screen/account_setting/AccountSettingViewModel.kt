package com.example.gitgrow.ui.screen.account_setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountSettingViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(AccountSettingUiState())
    val uiState: StateFlow<AccountSettingUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<AccountSettingUiEvent>()
    val uiEvent: MutableSharedFlow<AccountSettingUiEvent> = _uiEvent

    fun updateUserName(userName: String) {
        _uiState.update {
            it.copy(
                userName = userName,
            )
        }
    }

    fun onEvent(event: AccountSettingUiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
