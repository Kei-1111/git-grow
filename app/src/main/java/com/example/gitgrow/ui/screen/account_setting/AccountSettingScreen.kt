package com.example.gitgrow.ui.screen.account_setting

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import com.example.gitgrow.navigation.Screen
import com.example.gitgrow.ui.component.GitGrowTopBar
import com.example.gitgrow.ui.utils.showToast
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(ExperimentalLayoutApi::class)
@Suppress("ModifierMissing")
@Composable
fun AccountSettingScreen(
    navigateBack: () -> Unit,
    viewModel: AccountSettingViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val lifecycleOwner = LocalLifecycleOwner.current

    val latestNavigateBack by rememberUpdatedState(navigateBack)

    val context = LocalContext.current

    val imeVisible = WindowInsets.isImeVisible

    LaunchedEffect(lifecycleOwner, viewModel) {
        viewModel.uiEvent
            .flowWithLifecycle(lifecycleOwner.lifecycle)
            .onEach { event ->
                when (event) {
                    is AccountSettingUiEvent.OnUserNameChange -> {
                        viewModel.updateUserName(event.value)
                    }

                    is AccountSettingUiEvent.SaveUserName -> {
                        viewModel.saveUserName()
                    }

                    is AccountSettingUiEvent.SaveSuccess -> {
                        showToast(context, "保存しました")
                        latestNavigateBack()
                    }

                    is AccountSettingUiEvent.SaveFailure -> {
                        showToast(context, "保存に失敗しました")
                    }

                    is AccountSettingUiEvent.NavigateBack -> {
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
                currentScreen = Screen.AccountSetting,
                modifier = Modifier.fillMaxWidth(),
                navigateBack = { viewModel.onEvent(AccountSettingUiEvent.NavigateBack) },
            )
        },
    ) { innerPadding ->

        val paddingValue = if (imeVisible) {
            PaddingValues(
                top = innerPadding.calculateTopPadding(),
                start = innerPadding.calculateStartPadding(layoutDirection = LocalLayoutDirection.current),
                end = innerPadding.calculateEndPadding(layoutDirection = LocalLayoutDirection.current),
            )
        } else {
            innerPadding
        }

        AccountSettingScreenContent(
            uiState = uiState,
            onEvent = viewModel::onEvent,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
        )
    }
}
