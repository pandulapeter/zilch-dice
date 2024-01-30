package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ZilchDiceButton(
    modifier: Modifier = Modifier,
    text: String,
    shouldShowLoadingIndicator: Boolean = false,
    icon: ImageVector? = null,
    onClick: () -> Unit = {}
) = Button(
    modifier = modifier,
    shape = CircleShape,
    enabled = !shouldShowLoadingIndicator,
    content = {
        val color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        val iconSize = 24.dp
        Row(
            modifier = Modifier.height(iconSize + 8.dp).padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (shouldShowLoadingIndicator || icon != null) {
                Box(
                    modifier = Modifier.size(iconSize)
                ) {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = shouldShowLoadingIndicator,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(iconSize).padding(2.dp),
                            color = color,
                            strokeWidth = 3.dp,
                        )
                    }
                    icon?.let {
                        androidx.compose.animation.AnimatedVisibility(
                            visible = !shouldShowLoadingIndicator,
                            enter = fadeIn(),
                            exit = fadeOut()
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
            }
            ZilchDiceText(
                text = text
            )
        }
    },
    onClick = {
        if (!shouldShowLoadingIndicator) {
            onClick()
        }
    }
)