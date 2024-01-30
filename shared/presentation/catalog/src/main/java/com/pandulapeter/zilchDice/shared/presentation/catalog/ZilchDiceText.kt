package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ZilchDiceText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    shouldCenterAlign: Boolean = false,
    isBold: Boolean = false
) = Text(
    modifier = modifier,
    color = color,
    textAlign = if (shouldCenterAlign) TextAlign.Center else null,
    fontWeight = if (isBold) FontWeight.Bold else null,
    text = text
)