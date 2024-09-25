package com.example.gitgrow.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gitgrow.navigation.NavGraph

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavGraph(
        navController = navController,
        modifier = modifier,
    )
}
