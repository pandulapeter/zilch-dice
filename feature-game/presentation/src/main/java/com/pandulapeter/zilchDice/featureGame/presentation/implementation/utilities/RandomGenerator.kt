package com.pandulapeter.zilchDice.featureGame.presentation.implementation.utilities

import com.pandulapeter.zilchDice.featureGame.data.RolledDie
import com.pandulapeter.zilchDice.featureGame.presentation.implementation.mirror
import kotlin.math.roundToInt
import kotlin.random.Random

internal class RandomGenerator {

    private val random by lazy { Random(System.currentTimeMillis()) }

    fun float() = random.nextFloat()

    fun intBelow(maximum: Int) = (float() * maximum).roundToInt()

    fun intBetween(minimum: Int, maximum: Int) = minimum + intBelow(maximum)

    fun diceSide() = RolledDie.Side.entries.random()

    fun diceImageIndex(currentValue: RolledDie.ImageIndex?): RolledDie.ImageIndex {
        var nextValue: RolledDie.ImageIndex
        do {
            nextValue = RolledDie.ImageIndex.entries.random()
        } while (nextValue == currentValue?.mirror || nextValue == currentValue)
        return nextValue
    }
}