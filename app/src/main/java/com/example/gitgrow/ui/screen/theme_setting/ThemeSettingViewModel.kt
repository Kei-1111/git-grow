package com.example.gitgrow.ui.screen.theme_setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ThemeSettingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ThemeSettingUiState())
    val uiState: StateFlow<ThemeSettingUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<ThemeSettingUiEvent>()
    val uiEvent: MutableSharedFlow<ThemeSettingUiEvent> = _uiEvent

    fun selectGitGrowThemeColor() {
        _uiState.update {
            it.copy(
                useGitGrowThemeColor = true,
                useDynamicColor = false,
            )
        }
    }

    fun selectDynamicColor() {
        _uiState.update {
            it.copy(
                useGitGrowThemeColor = false,
                useDynamicColor = true,
            )
        }
    }

    fun onEvent(event: ThemeSettingUiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
