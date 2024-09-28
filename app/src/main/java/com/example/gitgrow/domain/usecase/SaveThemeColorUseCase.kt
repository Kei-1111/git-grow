package com.example.gitgrow.domain.usecase

interface SaveThemeColorUseCase {
    suspend operator fun invoke(
        useGitGrowThemeColor: Boolean,
        useDynamicColor: Boolean,
    )
}