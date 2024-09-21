package com.example.gitgrow.ui.screen.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Suppress("ModifierMissing")
@Composable
fun SettingsScreen(
    toAccountSetting: () -> Unit,
    toThemeSetting: () -> Unit,
) {
    SettingsScreenContent(
        toAccountSetting = toAccountSetting,
        toThemeSetting = toThemeSetting,
        modifier = Modifier
            .fillMaxSize(),
    )
}
