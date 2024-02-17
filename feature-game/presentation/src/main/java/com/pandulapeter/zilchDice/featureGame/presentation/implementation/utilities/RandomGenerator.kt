package com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities

import com.pandulapeter.zilchDice.featureGame.presentation.implementation.DiceState
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.mirror
import kotlin.math.roundToInt
import kotlin.random.Random

internal class RandomGenerator {

    private val random by lazy { Random(System.currentTimeMillis()) }

    fun float() = random.nextFloat()

    fun intBelow(maximum: Int) = (float() * maximum).roundToInt()

    fun intBetween(minimum: Int, maximum: Int) = minimum + intBelow(maximum)

    fun diceSide() = DiceState.Side.entries.random()

    fun diceImageIndex(currentValue: DiceState.ImageIndex?): DiceState.ImageIndex {
        var nextValue: DiceState.ImageIndex
        do {
            nextValue = DiceState.ImageIndex.entries.random()
        } while (nextValue == currentValue?.mirror || nextValue == currentValue)
        return nextValue
    }
}