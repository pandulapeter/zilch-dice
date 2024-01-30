package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ZilchDiceIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String?,
    onClick: () -> Unit = {}
) = IconButton(
    modifier = modifier,
    onClick = onClick
) {
    Icon(
        imageVector = icon,
        contentDescription = contentDescription
    )
}