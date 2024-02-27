package com.pandulapeter.zilchDice.featureGame.presentation.implementation

import com.pandulapeter.zilchDice.featureGame.data.RolledDie
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities.RandomGenerator
import com.pandulapeter.zilchDice.utilities.logger.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

internal class GameViewModel(
    private val randomGenerator: RandomGenerator
) {

    private val _rollState = MutableStateFlow(
        generateRollState(
            currentState = null
        )
    )
    val rollState = _rollState.asStateFlow()
    val savedDice = rollState.map { rollState ->
        rollState.filter { rolledDie ->
            rolledDie.isSaved
        }
    }
    val isRollButtonEnabled = _rollState.map { diceStates ->
        diceStates.any { !it.isSaved }
    }
    val rollValue = rollState.map { diceStateWrappers ->
        countPoints(diceStateWrappers.map { it.side })
    }

    fun onDiceSelected(id: Int) {
        _rollState.value = rollState.value.map { rolledDie ->
            if (rolledDie.id == id) {
                rolledDie.copy(
                    isSaved = !rolledDie.isSaved
                )
            } else {
                rolledDie
            }
        }
    }

    fun onRollButtonClicked() {
        _rollState.value = generateRollState(
            currentState = rollState.value
        )
    }

    fun reset() {
        _rollState.value = generateRollState(
            currentState = null
        )
    }

    private fun countPoints(diceSides: List<RolledDie.Side>) = diceSides.run {
        if (diceSides.sorted() == RolledDie.Side.entries.sorted()) {
            return@run 2500
        }
        var sum = 0
        sum += when (count { it == RolledDie.Side.ONE }) {
            1 -> 100
            2 -> 200
            3 -> 1000
            4 -> 2000
            5 -> 4000
            6 -> 8000
            else -> 0
        }
        sum += when (count { it == RolledDie.Side.TWO }) {
            3 -> 200
            4 -> 400
            5 -> 800
            6 -> 1600
            else -> 0
        }
        sum += when (count { it == RolledDie.Side.THREE }) {
            3 -> 300
            4 -> 600
            5 -> 1200
            6 -> 2400
            else -> 0
        }
        sum += when (count { it == RolledDie.Side.FOUR }) {
            3 -> 400
            4 -> 800
            5 -> 1600
            6 -> 3200
            else -> 0
        }
        sum += when (count { it == RolledDie.Side.FIVE }) {
            1 -> 50
            2 -> 100
            3 -> 500
            4 -> 1000
            5 -> 2000
            6 -> 4000
            else -> 0
        }
        sum += when (count { it == RolledDie.Side.SIX }) {
            3 -> 600
            4 -> 1200
            5 -> 2400
            6 -> 4800
            else -> 0
        }
        return@run sum
    }

    private fun generateRollState(currentState: List<RolledDie>?) = (0..5).map { index ->
        val currentRolledDie = currentState?.get(index)
        if (currentRolledDie?.isSaved == true) {
            currentRolledDie
        } else {
            RolledDie(
                id = currentRolledDie?.id ?: index,
                side = randomGenerator.diceSide(),
                imageIndex = randomGenerator.diceImageIndex(currentRolledDie?.imageIndex),
                isSaved = false
            )
        }
    }
        .sortedBy { it.side }
        .also { diceStates ->
            Logger.log("Game: DiceSides: ${diceStates.joinToString { it.side.name }}")
            Logger.log("Game: DiceImageIndices: ${diceStates.joinToString { it.imageIndex.name }}")
        }
}