package com.example.gitgrow.ui.screen.account_setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R
import com.example.gitgrow.ui.component.GitGrowTextField
import com.example.gitgrow.ui.component.LabelMediumText

@Composable
fun AccountSettingScreenContent(
    uiState: AccountSettingUiState,
    onEvent: (AccountSettingUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_padding)),
    ) {
        LabelMediumText(
            text = "コントリビュートを表示するGitHubアカウントのユーザー名を入力してください。",
        )
        GitGrowTextField(
            modifier = Modifier.fillMaxWidth(),
            text = uiState.userName,
            onTextChange = { onEvent(AccountSettingUiEvent.OnUserNameChange(it)) },
            label = "ユーザー名",
        )
    }
}
