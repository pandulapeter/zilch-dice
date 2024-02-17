package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import androidx.compose.runtime.mutableStateOf
import com.pandulapeter.zilchDice.featureGame.data.DiceState
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import com.pandulapeter.zilchDice.utilities.logger.Logger

internal class GameViewModel(
    private val randomGenerator: RandomGenerator
) {

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

    fun countPoints(diceSides: List<DiceState.Side>) = diceSides.run {
        if (diceSides.sorted() == DiceState.Side.entries.sorted()) {
            return@run 2500
        }
        var sum = 0
        sum += when (count { it == DiceState.Side.ONE }) {
            1 -> 100
            2 -> 200
            3 -> 1000
            4 -> 2000
            5 -> 4000
            6 -> 8000
            else -> 0
        }
        sum += when (count { it == DiceState.Side.TWO }) {
            3 -> 200
            4 -> 400
            5 -> 800
            6 -> 1600
            else -> 0
        }
        sum += when (count { it == DiceState.Side.THREE }) {
            3 -> 300
            4 -> 600
            5 -> 1200
            6 -> 2400
            else -> 0
        }
        sum += when (count { it == DiceState.Side.FOUR }) {
            3 -> 400
            4 -> 800
            5 -> 1600
            6 -> 3200
            else -> 0
        }
        sum += when (count { it == DiceState.Side.FIVE }) {
            1 -> 50
            2 -> 100
            3 -> 500
            4 -> 1000
            5 -> 2000
            6 -> 4000
            else -> 0
        }
        sum += when (count { it == DiceState.Side.SIX }) {
            3 -> 600
            4 -> 1200
            5 -> 2400
            6 -> 4800
            else -> 0
        }
        return@run sum
    }

    private fun generateDiceStates(currentState: List<DiceState>?) = (0..5).map { index ->
        DiceState(
            side = randomGenerator.diceSide(),
            imageIndex = randomGenerator.diceImageIndex(currentState?.get(index)?.imageIndex)
        )
    }.also { diceStates ->
        Logger.log("Game: DiceSides: ${diceStates.joinToString { it.side.name }}")
        Logger.log("Game: DiceImageIndices: ${diceStates.joinToString { it.imageIndex.name }}")
    }
}