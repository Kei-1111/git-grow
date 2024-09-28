package com.example.gitgrow.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R
import com.example.gitgrow.ui.theme.UiConfig

@Composable
fun GitGrowSaveButton(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.item_height)),
        enabled = enabled,
        shape = MaterialTheme.shapes.medium,
    ) {
        BodyMediumText(
            text = "保存",
            color = if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = UiConfig.DisabledContentAlpha)
            },
        )
    }
}
