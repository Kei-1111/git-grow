package com.example.gitgrow.ui.screen.theme_setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R
import com.example.gitgrow.ui.component.BodyMediumText
import com.example.gitgrow.ui.component.GitGrowSaveButton
import com.example.gitgrow.ui.component.LabelMediumText
import com.example.gitgrow.ui.theme.UiConfig

@Composable
fun ThemeSettingScreenContent(
    uiState: ThemeSettingUiState,
    onEvent: (ThemeSettingUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
    ) {
        LabelMediumText(
            text = "カラーテーマを選択してください",
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceContainer,
            shape = MaterialTheme.shapes.medium,
        ) {
            Column {
                ColorThemeSettingItem(
                    title = "アプリのカラーテーマを使用する",
                    selected = uiState.selectThemeColor.useGitGrowThemeColor,
                    onClick = { onEvent(ThemeSettingUiEvent.SelectGitGrowThemeColor) },
                    modifier = Modifier.fillMaxWidth(),
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
                )
                ColorThemeSettingItem(
                    title = "ダイナミックカラーを使用する",
                    selected = uiState.selectThemeColor.useDynamicColor,
                    onClick = { onEvent(ThemeSettingUiEvent.SelectDynamicColor) },
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        Spacer(
            modifier = Modifier.weight(UiConfig.DefaultWeight),
        )
        GitGrowSaveButton(
            onClick = { onEvent(ThemeSettingUiEvent.SaveThemeColor) },
            enabled = uiState.enableSaveButton,
        )
    }
}

@Composable
private fun ColorThemeSettingItem(
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clickable(
                onClick = onClick,
            )
            .height(dimensionResource(id = R.dimen.item_height))
            .padding(horizontal = dimensionResource(id = R.dimen.medium_padding)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BodyMediumText(
            text = title,
            modifier = Modifier.weight(UiConfig.DefaultWeight),
        )
        RadioButton(
            selected = selected,
            onClick = onClick,
        )
    }
}
