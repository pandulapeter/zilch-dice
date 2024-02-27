package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import com.pandulapeter.zilchDice.featureGame.data.DiceState
import com.pandulapeter.zilchDice.featureGame.data.DiceStateWrapper
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import com.pandulapeter.zilchDice.utilities.logger.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

internal class GameViewModel(
    private val randomGenerator: RandomGenerator
) {

    private val _diceStateWrappers = MutableStateFlow(
        generateDiceStates(
            currentState = null
        )
    )
    val diceStateWrappers = _diceStateWrappers.asStateFlow()
    val isRollButtonEnabled = _diceStateWrappers.map { diceStates ->
        diceStates.any { !it.diceState.isSaved }
    }
    val rollValue = diceStateWrappers.map { diceStateWrappers ->
        countPoints(diceStateWrappers.map { it.diceState.side })
    }

    fun onDiceSelected(id: String) {
        _diceStateWrappers.value = diceStateWrappers.value.map { diceStateWrapper ->
            if (diceStateWrapper.id == id) {
                diceStateWrapper.copy(
                    diceState = diceStateWrapper.diceState.copy(
                        isSaved = !diceStateWrapper.diceState.isSaved
                    )
                )
            } else {
                diceStateWrapper
            }
        }
    }

    fun onRollButtonClicked() {
        _diceStateWrappers.value = generateDiceStates(
            currentState = diceStateWrappers.value
        )
    }

    fun reset() {
        _diceStateWrappers.value = generateDiceStates(
            currentState = null
        )
    }

    private fun countPoints(diceSides: List<DiceState.Side>) = diceSides.run {
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

    private fun generateDiceStates(currentState: List<DiceStateWrapper>?) = (0..5).map { index ->
        val currentDiceStateWrapper = currentState?.get(index)
        if (currentDiceStateWrapper?.diceState?.isSaved == true) {
            currentDiceStateWrapper
        } else {
            DiceStateWrapper(
                id = currentDiceStateWrapper?.id ?: index.toString(),
                diceState = DiceState(
                    side = randomGenerator.diceSide(),
                    imageIndex = randomGenerator.diceImageIndex(currentDiceStateWrapper?.diceState?.imageIndex),
                    isSaved = false
                )
            )
        }
    }
        .sortedBy { it.diceState.side }
        .also { diceStates ->
            Logger.log("Game: DiceSides: ${diceStates.joinToString { it.diceState.side.name }}")
            Logger.log("Game: DiceImageIndices: ${diceStates.joinToString { it.diceState.imageIndex.name }}")
        }
}