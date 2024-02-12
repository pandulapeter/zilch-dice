package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject

@Composable
internal fun Dice(
    resourceProvider: ResourceProvider = inject(),
    diceState: DiceState,
    modifier: Modifier = Modifier,
) = Image(
    modifier = modifier.size(72.dp),
    painter = diceState.painter(
        painters = resourceProvider.painters,
    ),
    contentDescription = null,
)