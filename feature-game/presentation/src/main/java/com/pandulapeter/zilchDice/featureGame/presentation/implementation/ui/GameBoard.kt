package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.data.DiceState
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.GameViewModel
import com.pandulapeter.zilchDice.shared.presentation.catalog.ZilchDiceButton
import com.pandulapeter.zilchDice.shared.presentation.resources.api.ResourceProvider
import com.pandulapeter.zilchDice.utilities.extensions.inject
import com.pandulapeter.zilchDice.utilities.logger.Logger

@Composable
internal fun GameBoard(
    resourceProvider: ResourceProvider = inject(),
    viewModel: GameViewModel = inject(),
    modifier: Modifier = Modifier
) = Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    DiceRow(
        diceStates = viewModel.diceStates.value
    )
    Spacer(
        modifier = Modifier.height(16.dp)
    )
    val diceSides = viewModel.diceStates.value.map { it.side }
    Text(
        modifier = Modifier.padding(bottom = 16.dp),
        text = "Roll value: ${viewModel.countPoints(diceSides)}"
    )
    ZilchDiceButton(
        text = resourceProvider.strings.gameRoll,
        onClick = {
            Logger.log("Game: 'Roll' button clicked.")
            viewModel.onRollButtonClicked()
        }
    )
}

@Composable
private fun DiceRow(
    modifier: Modifier = Modifier,
    diceStates: List<DiceState>
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center
) {
    diceStates.forEach { diceState ->
        Dice(
            diceState = diceState,
        )
    }
}