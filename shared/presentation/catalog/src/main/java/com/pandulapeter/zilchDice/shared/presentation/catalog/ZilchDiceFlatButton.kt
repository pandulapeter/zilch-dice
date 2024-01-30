package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ZilchDiceFlatButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit = {}
) = TextButton(
    modifier = modifier,
    content = {
        val color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        val iconSize = 24.dp
        Row(
            modifier = Modifier.height(iconSize + 8.dp).padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (icon != null) {
                Box(
                    modifier = Modifier.size(iconSize)
                ) {
                    Icon(
                        modifier = Modifier.size(iconSize),
                        imageVector = icon,
                        tint = color,
                        contentDescription = null
                    )
                }

            }
        }
        ZilchDiceText(
            text = text
        )
    },
    onClick = onClick
)