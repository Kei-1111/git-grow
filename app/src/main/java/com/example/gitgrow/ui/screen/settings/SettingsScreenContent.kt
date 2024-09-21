package com.example.gitgrow.ui.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gitgrow.ui.component.LabelMediumText

@Composable
fun SettingsScreenContent(
    toAccountSetting: () -> Unit,
    toThemeSetting: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column {
            LabelMediumText(
                text = "アカウント設定",
            )
            Button(
                onClick = toAccountSetting,
            ) {
                Text("Account Setting")
            }
        }
        Column {
            LabelMediumText(
                text = "テーマ設定",
            )
            Button(
                onClick = toThemeSetting,
            ) {
                Text("Theme Setting")
            }
        }
    }
}
