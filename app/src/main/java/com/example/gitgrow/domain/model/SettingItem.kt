package com.example.gitgrow.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Palette
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.persistentListOf

data class SettingItem(
    val itemName: String,
    val icon: ImageVector,
)

data object AccountSettings {
    val list = persistentListOf(
        SettingItem(
            itemName = "ユーザー名",
            icon = Icons.Default.AccountCircle,
        ),
    )
}

data object ThemeSettings {
    val list = persistentListOf(
        SettingItem(
            itemName = "カラーテーマ",
            icon = Icons.Default.Palette,
        ),
    )
}
