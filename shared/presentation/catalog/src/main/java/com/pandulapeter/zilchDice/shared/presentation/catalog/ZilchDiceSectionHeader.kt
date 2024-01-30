package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ZilchDiceSectionHeader(
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    text: String,
) = Row(
    modifier = modifier.fillMaxWidth()
        .padding(
            horizontal = if (icon == null) 16.dp else 12.dp,
            vertical = 8.dp
        )
        .padding(
            bottom = 4.dp
        ),
    verticalAlignment = Alignment.CenterVertically
) {
    if (icon != null) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon,
            contentDescription = text,
            tint = MaterialTheme.colors.primary,
        )
        Spacer(
            modifier = Modifier.size(12.dp)
        )
    }
    ZilchDiceText(
        isBold = true,
        text = text
    )
}