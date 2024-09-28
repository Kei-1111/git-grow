package com.example.gitgrow.domain.usecase

interface SaveUserNameUseCase {
    suspend operator fun invoke(userName: String)
}
