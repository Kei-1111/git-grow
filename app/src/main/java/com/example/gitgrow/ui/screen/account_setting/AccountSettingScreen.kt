package com.example.gitgrow.ui.screen.account_setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gitgrow.navigation.Screen
import com.example.gitgrow.ui.component.GitGrowTopBar

@Suppress("ModifierMissing")
@Composable
fun AccountSettingScreen(
    back: () -> Unit,
    accountSettingViewModel: AccountSettingViewModel = viewModel(),
) {
    val uiState by accountSettingViewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GitGrowTopBar(
                currentScreen = Screen.AccountSetting,
                modifier = Modifier.fillMaxWidth(),
                back = back,
            )
        },
    ) { innerPadding ->
        AccountSettingScreenContent(
            uiState = uiState,
            updateUserName = accountSettingViewModel::updateUserName,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}
