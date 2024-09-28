package com.example.gitgrow.di

import com.example.gitgrow.domain.repository.UserSettingsRepository
import com.example.gitgrow.domain.usecase.GetUserSettingsUseCase
import com.example.gitgrow.domain.usecase.GetUserSettingsUseCaseImpl
import com.example.gitgrow.domain.usecase.SaveThemeColorUseCase
import com.example.gitgrow.domain.usecase.SaveThemeColorUseCaseImpl
import com.example.gitgrow.domain.usecase.SaveUserNameUseCase
import com.example.gitgrow.domain.usecase.SaveUserNameUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetUserSettingsUseCase(
        userSettingsRepository: UserSettingsRepository
    ): GetUserSettingsUseCase = GetUserSettingsUseCaseImpl(userSettingsRepository)

    @Provides
    @Singleton
    fun provideSaveUserNameUseCase(
        userSettingsRepository: UserSettingsRepository
    ): SaveUserNameUseCase = SaveUserNameUseCaseImpl(userSettingsRepository)

    @Provides
    @Singleton
    fun provideSaveThemeColorUseCase(
        userSettingsRepository: UserSettingsRepository
    ): SaveThemeColorUseCase = SaveThemeColorUseCaseImpl(userSettingsRepository)
}
