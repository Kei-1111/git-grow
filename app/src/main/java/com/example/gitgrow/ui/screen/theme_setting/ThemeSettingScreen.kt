package com.example.gitgrow.ui.screen.theme_setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import com.example.gitgrow.navigation.Screen
import com.example.gitgrow.ui.component.GitGrowTopBar
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Suppress("ModifierMissing")
@Composable
fun ThemeSettingScreen(
    navigateBack: () -> Unit,
    viewModel: ThemeSettingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    val latestNavigateBack by rememberUpdatedState(navigateBack)

    LaunchedEffect(lifecycleOwner, viewModel) {
        viewModel.uiEvent
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .onEach { event ->
                when (event) {
                    is ThemeSettingUiEvent.SelectGitGrowThemeColor -> {
                        viewModel.selectGitGrowThemeColor()
                    }
                    is ThemeSettingUiEvent.SelectDynamicColor -> {
                        viewModel.selectDynamicColor()
                    }
                    is ThemeSettingUiEvent.NavigateBack -> {
                        latestNavigateBack()
                    }
                }
            }
            .launchIn(this)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GitGrowTopBar(
                currentScreen = Screen.ThemeSetting,
                modifier = Modifier.fillMaxWidth(),
                navigateBack = navigateBack,
            )
        },
    ) { innerPadding ->
        ThemeSettingScreenContent(
            uiState = uiState,
            onEvent = viewModel::onEvent,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}
