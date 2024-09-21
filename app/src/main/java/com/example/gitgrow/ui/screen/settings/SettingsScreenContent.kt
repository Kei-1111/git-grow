package com.example.gitgrow.ui.screen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R
import com.example.gitgrow.ui.component.BodyMediumText
import com.example.gitgrow.ui.component.LabelMediumText
import com.example.gitgrow.ui.theme.UiConfig
import kotlinx.collections.immutable.ImmutableList

@Composable
fun SettingsScreenContent(
    toAccountSetting: () -> Unit,
    toThemeSetting: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.medium_padding)),
    ) {
        AccountSetting(
            toAccountSetting = toAccountSetting,
            modifier = Modifier.fillMaxWidth(),
        )
        ThemeSetting(
            toThemeSetting = toThemeSetting,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun AccountSetting(
    toAccountSetting: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SettingsScreenItem(
        title = "アカウント設定",
        settingItems = AccountSettings.list,
        onClick = toAccountSetting,
        modifier = modifier,
    )
}

@Composable
fun ThemeSetting(
    toThemeSetting: () -> Unit,
    modifier: Modifier = Modifier,
) {
    SettingsScreenItem(
        title = "テーマ設定",
        settingItems = ThemeSettings.list,
        onClick = toThemeSetting,
        modifier = modifier,
    )
}

@Composable
fun SettingsScreenItem(
    title: String,
    settingItems: ImmutableList<SettingItem>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
    ) {
        LabelMediumText(
            text = title,
        )
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = onClick,
                ),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceContainerHighest,
        ) {
            Column {
                settingItems.forEachIndexed { index, settingItem ->
                    SettingItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(
                                onClick = onClick,
                            ),
                        settingItem = settingItem,
                    )
                }
            }
        }
    }
}

@Composable
fun SettingItem(
    settingItem: SettingItem,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = settingItem.icon,
            contentDescription = settingItem.itemName,
            tint = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.small_padding)),
        )
        BodyMediumText(
            text = settingItem.itemName,
            modifier = Modifier.weight(UiConfig.DefaultWeight),
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Next",
        )
    }
}
