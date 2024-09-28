package com.example.gitgrow.ui.screen.theme_setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitgrow.domain.model.ThemeColor
import com.example.gitgrow.domain.usecase.GetUserSettingsUseCase
import com.example.gitgrow.domain.usecase.SaveThemeColorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeSettingViewModel @Inject constructor(
    private val getUserSettingsUseCase: GetUserSettingsUseCase,
    private val saveThemeColorUseCase: SaveThemeColorUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ThemeSettingUiState())
    val uiState: StateFlow<ThemeSettingUiState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<ThemeSettingUiEvent>()
    val uiEvent: MutableSharedFlow<ThemeSettingUiEvent> = _uiEvent

    init {
        viewModelScope.launch {
            getUserSettingsUseCase().collect { userSettings ->
                _uiState.update {
                    val themeColorSettings = userSettings.themeColor
                    it.copy(
                        selectThemeColor = themeColorSettings,
                        initialThemeColor = themeColorSettings,
                    )
                }
            }
        }
    }

    fun selectGitGrowThemeColor() {
        val selectThemeColor = ThemeColor(
            useGitGrowThemeColor = true,
            useDynamicColor = false,
        )
        _uiState.update {
            it.copy(
                selectThemeColor = selectThemeColor,
                enableSaveButton = selectThemeColor != it.initialThemeColor,
            )
        }
    }

    fun selectDynamicColor() {
        val selectThemeColor = ThemeColor(
            useGitGrowThemeColor = false,
            useDynamicColor = true,
        )
        _uiState.update {
            it.copy(
                selectThemeColor = selectThemeColor,
                enableSaveButton = selectThemeColor != it.initialThemeColor,
            )
        }
    }

    fun saveThemeColor() {
        _uiState.update {
            it.copy(
                initialThemeColor = it.selectThemeColor,
                enableSaveButton = false,
            )
        }
        viewModelScope.launch {
            try {
                saveThemeColorUseCase(uiState.value.selectThemeColor)
                _uiEvent.emit(ThemeSettingUiEvent.SaveSuccess)
            } catch (e: Exception) {
                _uiEvent.emit(ThemeSettingUiEvent.SaveFailure)
            }
        }
    }

    fun onEvent(event: ThemeSettingUiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}
