package com.pandulapeter.zilchDice.featureGame.presentation.implementation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.data.DiceState
import com.pandulapeter.zilchDice.featureGame.data.DiceStateWrapper
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
    val diceStates = viewModel.diceStateWrappers.collectAsState()
    SavedDiceRow(
        diceStates = diceStates.value.map { it.diceState }
    )
    DiceRow(
        diceStateWrappers = diceStates.value,
        onDiceSelected = viewModel::onDiceSelected
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DiceRow(
    modifier: Modifier = Modifier,
    diceStateWrappers: List<DiceStateWrapper>,
    onDiceSelected: (String) -> Unit
) = Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    LazyVerticalGrid(
        modifier = Modifier.sizeIn(maxWidth = 720.dp),
        columns = GridCells.Fixed(diceStateWrappers.size),
    ) {
        items(
            count = diceStateWrappers.size,
            key = { diceStateWrappers[it].id }
        ) {
            Dice(
                modifier = Modifier.animateItemPlacement(),
                diceStateWrapper = diceStateWrappers[it],
                onDiceSelected = onDiceSelected
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SavedDiceRow(
    modifier: Modifier = Modifier.fillMaxWidth(),
    diceStates: List<DiceState>,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 48.dp)
) {
    AnimatedVisibility(
        modifier = Modifier.fillMaxWidth(),
        visible = diceStates.any { it.isSaved },
        enter = fadeIn() + scaleIn(),
        exit = scaleOut() + fadeOut()
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            diceStates
                .sortedBy { it.side }
                .forEachIndexed { index, diceState ->
                    if (diceState.isSaved) {
                        item(key = index) {
                            DiceTop(
                                modifier = Modifier.animateItemPlacement(
                                    animationSpec = tween(
                                        durationMillis = 200,
                                        easing = Ease,
                                    )
                                ),
                                diceState = diceState
                            )
                        }
                    }
                }
        }
    }
}