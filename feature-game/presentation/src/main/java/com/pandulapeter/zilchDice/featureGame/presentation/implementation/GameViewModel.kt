package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.runtime.mutableStateOf
import com.pandulapeter.zilchDice.utilities.logger.Logger

internal class GameViewModel {

    val diceStates = mutableStateOf(
        generateDiceStates(
            currentState = null
        )
    )

    fun onRollButtonClicked() {
        diceStates.value = generateDiceStates(
            currentState = diceStates.value
        )
    }

    private fun generateDiceStates(currentState: List<DiceState>?) = (0..4).map { index ->
        DiceState(
            side = DiceState.Side.random(),
            imageIndex = DiceState.ImageIndex.random(currentState?.get(index)?.imageIndex)
        )
    }.also { diceStates ->
        Logger.log("Game: DiceSides: ${diceStates.joinToString { it.side.name }}")
        Logger.log("Game: DiceImageIndices: ${diceStates.joinToString { it.imageIndex.name }}")
    }
}