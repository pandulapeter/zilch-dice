package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
private fun preview() = Column(
    modifier = Modifier.padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    ZilchDiceIconButton(
        icon = Icons.Default.Settings,
        contentDescription = "Settings icon button"
    )
}