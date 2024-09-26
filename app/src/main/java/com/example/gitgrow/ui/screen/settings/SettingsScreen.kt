package com.example.gitgrow.ui.screen.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gitgrow.navigation.Screen
import com.example.gitgrow.ui.component.GitGrowTopBar

@Suppress("ModifierMissing")
@Composable
fun SettingsScreen(
    toAccountSetting: () -> Unit,
    toThemeSetting: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GitGrowTopBar(
                currentScreen = Screen.Settings,
                modifier = Modifier.fillMaxWidth(),
            )
        },
    ) { innerPadding ->
        SettingsScreenContent(
            toAccountSetting = toAccountSetting,
            toThemeSetting = toThemeSetting,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}
