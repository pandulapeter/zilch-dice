package com.pandulapeter.zilchDice.shared.presentation.catalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ZilchDiceRadioButton(
    modifier: Modifier = Modifier,
    inset: Dp = 0.dp,
    selected: Boolean,
    onClick: () -> Unit,
    text: String
) = Row(
    modifier = modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(horizontal = inset),
    verticalAlignment = Alignment.CenterVertically
) {
    RadioButton(
        selected = selected,
        onClick = onClick
    )
    ZilchDiceText(
        text = text
    )
}