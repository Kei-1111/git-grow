package com.example.gitgrow.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gitgrow.ui.screen.account_setting.AccountSettingScreen
import com.example.gitgrow.ui.screen.settings.SettingsScreen
import com.example.gitgrow.ui.screen.theme_setting.ThemeSettingScreen
import com.example.gitgrow.ui.theme.AnimationConfig

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = Screen.Settings,
    ) {
        composable<Screen.Settings> {
            SettingsScreen(
                toAccountSetting = {
                    navController.navigate(Screen.AccountSetting)
                },
                toThemeSetting = {
                    navController.navigate(Screen.ThemeSetting)
                },
            )
        }
        composable<Screen.AccountSetting>(
            enterTransition = {
                slideInHorizontally(
                    animationSpec = tween(AnimationConfig.SlideInDurationMillis),
                    initialOffsetX = { it },
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(AnimationConfig.SlideOutDurationMillis),
                    targetOffsetX = { it },
                )
            },
        ) {
            AccountSettingScreen()
        }
        composable<Screen.ThemeSetting>(
            enterTransition = {
                slideInHorizontally(
                    animationSpec = tween(AnimationConfig.SlideInDurationMillis),
                    initialOffsetX = { it },
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(AnimationConfig.SlideOutDurationMillis),
                    targetOffsetX = { it },
                )
            },
        ) {
            ThemeSettingScreen()
        }
    }
}
