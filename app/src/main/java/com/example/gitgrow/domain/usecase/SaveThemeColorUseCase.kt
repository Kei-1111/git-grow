package com.example.gitgrow.domain.usecase

import com.example.gitgrow.domain.model.ThemeColor

interface SaveThemeColorUseCase {
    suspend operator fun invoke(themeColor: ThemeColor)
}
