package com.example.gitgrow.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.gitgrow.R

@Composable
fun GitGrowTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceContainerHighest,
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.medium,
    ) {
        Box(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.medium_padding)),
        ) {
            if (text.isEmpty()) {
                BodyMediumText(
                    text = label,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                )
            }
            BasicTextField(
                value = text,
                onValueChange = onTextChange,
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
