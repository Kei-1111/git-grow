package com.example.gitgrow.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R
import com.example.gitgrow.navigation.Screen

@Composable
fun GitGrowTopBar(
    currentScreen: Screen,
    modifier: Modifier = Modifier,
    navigateBack: () -> Unit = {},
) {
    val topPadding = WindowInsets.safeDrawing.asPaddingValues().calculateTopPadding()

    Surface(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.top_app_bar_height) + topPadding),
        color = MaterialTheme.colorScheme.primaryContainer,
    ) {
        GitGrowTopBarContent(
            currentScreen = currentScreen,
            navigateBack = navigateBack,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
fun GitGrowTopBarContent(
    currentScreen: Screen,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
    ) {
        if (currentScreen != Screen.Settings) {
            IconButton(
                onClick = navigateBack,
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
        when (currentScreen) {
            Screen.Settings -> {
                TitleLargeText(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding)),
                    text = "設定",
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            Screen.AccountSetting -> {
                TitleLargeText(
                    text = "アカウント設定",
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            Screen.ThemeSetting -> {
                TitleLargeText(
                    text = "テーマ設定",
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}
