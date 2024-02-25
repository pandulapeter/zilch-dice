package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    val diceStates = viewModel.diceStates.collectAsState()
    DiceRow(
        diceStates = diceStates.value,
        onDiceSelected = viewModel::onDiceSelected
    )
    val savedDiceStates = viewModel.savedDiceStates.collectAsState(emptyList())
    SavedDiceRow(
        diceStates = savedDiceStates.value
    )
    val rollValue = viewModel.rollValue.collectAsState(0)
    Text(
        modifier = Modifier.padding(bottom = 16.dp),
        text = "Roll value: ${rollValue.value}"
    )
    val isRollButtonEnabled = viewModel.isRollButtonEnabled.collectAsState(false)
    ZilchDiceButton(
        text = resourceProvider.strings.gameRoll,
        isEnabled = isRollButtonEnabled.value,
        onClick = {
            Logger.log("Game: 'Roll' button clicked.")
            viewModel.onRollButtonClicked()
        }
    )
}

@Composable
private fun DiceRow(
    modifier: Modifier = Modifier,
    diceStates: List<DiceState>,
    onDiceSelected: (Int) -> Unit
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center
) {
    Row(
        modifier = Modifier.sizeIn(maxWidth = 720.dp)
    ) {
        diceStates.forEachIndexed { diceIndex, diceState ->
            Dice(
                modifier = Modifier.weight(1f),
                diceState = diceState,
                diceIndex = diceIndex,
                onDiceSelected = onDiceSelected
            )
        }
    }
}

@Composable
private fun SavedDiceRow(
    modifier: Modifier = Modifier,
    diceStates: List<DiceState>,
) = Row(
    modifier = modifier.defaultMinSize(minHeight = 48.dp),
    horizontalArrangement = Arrangement.Center
) {
    diceStates.filter { it.isSaved }.forEach { diceState ->
        DiceTop(
            diceState = diceState
        )
    }
}