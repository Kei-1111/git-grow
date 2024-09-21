package com.example.gitgrow.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gitgrow.navigation.NavGraph
import com.example.gitgrow.navigation.Screen
import com.example.gitgrow.ui.component.GitGrowTopBar

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = currentBackStackEntry?.fromRoute() ?: Screen.Settings

    Scaffold(
        modifier = modifier,
        topBar = {
            GitGrowTopBar(
                currentScreen = currentScreen,
                modifier = Modifier.fillMaxWidth(),
                back = {
                    navController.popBackStack()
                },
            )
        },
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        )
    }
}

@Suppress("ReturnCount")
fun NavBackStackEntry?.fromRoute(): Screen {
    this?.destination?.route?.substringBefore("?")?.substringBefore("/")
        ?.substringAfterLast(".")?.let {
            when (it) {
                Screen.Settings::class.simpleName -> return Screen.Settings
                Screen.AccountSetting::class.simpleName -> return Screen.AccountSetting
                Screen.ThemeSetting::class.simpleName -> return Screen.ThemeSetting
                else -> return Screen.Settings
            }
        }
    return Screen.Settings
}
