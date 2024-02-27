package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    verticalArrangement = Arrangement.spacedBy(16.dp)
) {
    val savedDice = viewModel.savedDice.collectAsState(emptyList())
    SavedDieRow(
        savedDice = savedDice.value
    )
    val rollState = viewModel.rollState.collectAsState()
    DieRow(
        rolledDice = rollState.value,
        onDieSelected = viewModel::onDiceSelected
    )
    val rollValue = viewModel.rollValue.collectAsState(0)
    Text(
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