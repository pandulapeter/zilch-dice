package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject
import com.pandulapeter.zilchDice.utilities.logger.Logger

@Composable
internal fun Dice(
    resourceProvider: ResourceProvider = inject(),
    modifier: Modifier = Modifier,
    diceState: DiceState,
    onClick: () -> Unit,
) {
    LaunchedEffect(diceState) {
        Logger.log("Game: Dice initialized (side ${diceState.side}, index ${diceState.imageIndex}).")
    }
    Image(
        modifier = modifier.clickable { onClick() },
        painter = diceState.painter(
            painters = resourceProvider.painters,
        ),
        contentDescription = null,
    )
}