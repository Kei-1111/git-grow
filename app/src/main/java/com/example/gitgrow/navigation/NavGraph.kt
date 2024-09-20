package com.example.gitgrow.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gitgrow.ui.screen.account_setting.AccountSettingScreen
import com.example.gitgrow.ui.screen.settings.SettingsScreen
import com.example.gitgrow.ui.screen.theme_setting.ThemeSettingScreen

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
        composable<Screen.Settings>(

        ) {
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
                    animationSpec = tween(700),
                    initialOffsetX = { it }
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(700),
                    targetOffsetX = { it }
                )
            }
        ) {
            AccountSettingScreen()
        }
        composable<Screen.ThemeSetting>(
            enterTransition = {
                slideInHorizontally(
                    animationSpec = tween(700),
                    initialOffsetX = { it }
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    animationSpec = tween(700),
                    targetOffsetX = { it }
                )
            }
        ) {
            ThemeSettingScreen()
        }
    }
}
