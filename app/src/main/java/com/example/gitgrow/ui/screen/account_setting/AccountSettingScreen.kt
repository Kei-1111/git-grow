package com.example.gitgrow.ui.screen.account_setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Suppress("ModifierMissing")
@Composable
fun AccountSettingScreen(
    accountSettingViewModel: AccountSettingViewModel = viewModel(),
) {
    val uiState by accountSettingViewModel.uiState.collectAsState()

    AccountSettingScreenContent(
        uiState = uiState,
        updateUserName = accountSettingViewModel::updateUserName,
        modifier = Modifier
            .fillMaxSize(),
    )
}
