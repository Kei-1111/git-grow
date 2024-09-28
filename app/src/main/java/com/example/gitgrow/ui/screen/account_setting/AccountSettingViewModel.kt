package com.example.gitgrow.ui.screen.account_setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitgrow.domain.usecase.GetUserSettingsUseCase
import com.example.gitgrow.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountSettingViewModel @Inject constructor(
    private val getUserSettingsUseCase: GetUserSettingsUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(AccountSettingUiState())
    val uiState: StateFlow<AccountSettingUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<AccountSettingUiEvent>()
    val uiEvent: MutableSharedFlow<AccountSettingUiEvent> = _uiEvent

    init {
        viewModelScope.launch {
            getUserSettingsUseCase().collect { userSettings ->
                val userName = userSettings.userName
                _uiState.update {
                    it.copy(
                        userName = userName,
                        initialUserName = userName,
                    )
                }
            }
        }
    }

    fun updateUserName(userName: String) {
        _uiState.update {
            it.copy(
                userName = userName,
                enableSaveButton = userName != it.initialUserName,
            )
        }
    }

    fun saveUserName() {
        _uiState.update {
            it.copy(
                initialUserName = it.userName,
                enableSaveButton = false,
            )
        }
        viewModelScope.launch {
            try {
                saveUserNameUseCase(uiState.value.userName)
                _uiEvent.emit(AccountSettingUiEvent.SaveSuccess)
            } catch (e: Exception) {
                _uiEvent.emit(AccountSettingUiEvent.SaveFailure)
            }
        }
    }

    fun onEvent(event: AccountSettingUiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
