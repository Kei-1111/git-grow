package com.example.gitgrow.domain.model

data class UserSettings(
    val userName: String = "",
    val useGitGrowThemeColor: Boolean = true,
    val useDynamicColor: Boolean = false,
)
