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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pandulapeter.zilchDice.featureGame.data.RolledDie
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
    SavedDiceRow(
        savedDice = savedDice.value
    )
    val rollState = viewModel.rollState.collectAsState()
    DiceRow(
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun DiceRow(
    modifier: Modifier = Modifier,
    rolledDice: List<RolledDie>,
    onDieSelected: (Int) -> Unit
) = Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
) {
    LazyVerticalGrid(
        modifier = Modifier.sizeIn(maxWidth = 720.dp),
        columns = GridCells.Fixed(rolledDice.size),
    ) {
        items(
            count = rolledDice.size,
            key = { rolledDice[it].id }
        ) {
            Die(
                modifier = Modifier.animateItemPlacement(
                    animationSpec = tween(
                        durationMillis = 200,
                        easing = Ease,
                    )
                ),
                rolledDie = rolledDice[it],
                onDiceSelected = onDieSelected
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun SavedDiceRow(
    modifier: Modifier = Modifier.fillMaxWidth(),
    savedDice: List<RolledDie>,
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .defaultMinSize(minHeight = 48.dp)
) {
    AnimatedVisibility(
        modifier = Modifier.fillMaxWidth(),
        visible = savedDice.any { it.isSaved },
        enter = fadeIn() + scaleIn(),
        exit = scaleOut() + fadeOut()
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            items(
                items = savedDice,
                key = { it.id }
            ) { rolledDie ->
                DieTop(
                    modifier = Modifier.animateItemPlacement(
                        animationSpec = tween(
                            durationMillis = 200,
                            easing = Ease,
                        )
                    ),
                    rolledDie = rolledDie
                )
            }
        }
    }
}