package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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

@Preview
@Composable
private fun preview() = Column(
    modifier = Modifier.padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    ZilchDiceText(
        text = "Text"
    )
}